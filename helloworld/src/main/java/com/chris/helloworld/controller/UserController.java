package com.chris.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chris.helloworld.member.CurrentUsers;
import com.chris.helloworld.repo.*;

//This was an attempt to link my database, technically it worked,  but I'm going to wait more on DB integration before utiliing this
//May potentially be scrapped all together
@RestController
@ComponentScan(basePackages = "com.chris.helloworld")
@RequestMapping(path="/demo")
public class UserController {
	@Autowired 
	private UserRepository userRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String name
		, @RequestParam String email) {
	// 	
			CurrentUsers n = new CurrentUsers();
			n.setName(name);
			n.setEmail(email);
			userRepository.save(n);
			return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<CurrentUsers> getAllUsers() {
		
		return userRepository.findAll();
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "empty";
	}
}
