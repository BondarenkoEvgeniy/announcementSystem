package com.senla.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/test")
@RestController
public class HomeController {

	@GetMapping("/")
	public String getIndex(){
		return "index";
	}
	
	@GetMapping("/welcome")
	public String getWelcome(){
		return "welcome";
	}


}
