package com.tmdt.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value="/auth" ,produces=MediaType.APPLICATION_JSON_VALUE)
public class PostController {
  
	@RequestMapping(value="add")
	public String add() {
	  	return "hihi";
	}
	
}
