package com.tmdt.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test")
public class HomeController {
    
	@RequestMapping(value="hello", method= RequestMethod.GET)
	public String index() {
		return "{ 'huynh tinh' : 'thanh' }";
	}
}
