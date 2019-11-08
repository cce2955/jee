package com.chris.helloworld.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chris.helloworld.IdBean;

@ComponentScan(basePackages = "com.chris.helloworld")
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
	
	 private static final String template = "Hello, %s!";
	 private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/id")
	public IdBean idgreet(@RequestParam(value="name", defaultValue="World") String name) {
        return new IdBean(counter.incrementAndGet(),
                String.format(template, name));
	}
	
		
	
	
}