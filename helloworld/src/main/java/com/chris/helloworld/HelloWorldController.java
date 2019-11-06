package com.chris.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/")
	public String hello()
	{
		return "testing";
	}
	
	@GetMapping("/math")
	public int math()
	{
		return 2+3;
	}
}
