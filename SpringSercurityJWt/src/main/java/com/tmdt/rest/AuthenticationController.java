package com.tmdt.rest;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tmdt.common.CustomErrorType;
import com.tmdt.common.DeviceProvider;
import com.tmdt.domain.Customer;
import com.tmdt.model.UserTokenState;
import com.tmdt.security.TokenHelper;
import com.tmdt.security.auth.JwtAuthenticationRequest;

/**
 * Created by fan.jin on 2017-05-10.
 */

@RestController
@RequestMapping( value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE )
public class AuthenticationController {

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DeviceProvider deviceProvider;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest,
            HttpServletResponse response,
            Device device
    ) throws AuthenticationException, IOException {
     try {
         final Authentication authentication = authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(
                         authenticationRequest.getUsername(),
                         authenticationRequest.getPassword()
                 )
         );

         // Inject into security context
         SecurityContextHolder.getContext().setAuthentication(authentication);

         // token creation
         Customer user = (Customer)authentication.getPrincipal();
         String jws = tokenHelper.generateToken( user.getUsername(), device);
         int expiresIn = tokenHelper.getExpiredIn(device);
         // Add cookie to response
         response.addCookie( createAuthCookie( jws, expiresIn ) );
         // Return the token
         return ResponseEntity.ok(new UserTokenState(jws, expiresIn));
    	 
     }catch (Exception  e ) {
		// TODO: handle exception
    	  return new ResponseEntity(new CustomErrorType("Không tìm thấy not found."),
                 HttpStatus.FORBIDDEN);
	}
        // Perform the security
   
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAuthenticationToken(
            HttpServletRequest request,
            HttpServletResponse response,
            Principal principal
            ) {

        String authToken = tokenHelper.getToken( request );

        Device device = deviceProvider.getCurrentDevice(request);

        if (authToken != null && principal != null) {

            // TODO check user password last update
            String refreshedToken = tokenHelper.refreshToken(authToken, device);
            int expiresIn = tokenHelper.getExpiredIn(device);

            // Add cookie to response
            response.addCookie( createAuthCookie( refreshedToken, expiresIn ) );

            return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
        } else {
            UserTokenState userTokenState = new UserTokenState();
            return ResponseEntity.accepted().body(userTokenState);
        }
    }

    private Cookie createAuthCookie(String jwt, int expiresIn) {
        Cookie authCookie = new Cookie( tokenHelper.AUTH_COOKIE, ( jwt ) );
        authCookie.setPath( "/" );
        authCookie.setHttpOnly( true );
        authCookie.setMaxAge( expiresIn );
        return authCookie;
    }
}