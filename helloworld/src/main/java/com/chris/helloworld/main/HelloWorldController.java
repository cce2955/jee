package com.chris.helloworld.main;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chris.helloworld.IdBean;

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