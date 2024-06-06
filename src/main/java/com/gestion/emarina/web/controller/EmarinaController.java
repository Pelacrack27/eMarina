package com.gestion.emarina.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmarinaController {

	
	@GetMapping("/emarina")
	public String home() {
	   
	    return "/emarina/emarina"; 
	}
	
	

	@GetMapping("/login")
	public String login() {
	   
	    return "index"; 
	}
	
}
