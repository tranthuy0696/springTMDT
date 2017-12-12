package com.tmdt.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tmdt.domain.Customer;
import com.tmdt.repository.CustomerRepository;

@Service
public class UserServiceImpl implements UserDetailsService{
@Autowired
private CustomerRepository customerRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer=customerRepository.findByUsername(username);
		if(customer==null) {
			 throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		}
		return customer;
	}

}