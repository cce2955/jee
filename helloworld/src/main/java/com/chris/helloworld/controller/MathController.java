package com.chris.helloworld.controller;

import org.hibernate.criterion.NotNullExpression;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.helloworld.member.MathMember;
import com.sun.istack.NotNull;


@RestController
@ComponentScan(basePackages = "com.chris.helloworld")
@RequestMapping(path="/equation")
public class MathController {
 

	@RequestMapping(path="/add/{a}/{b}")
	public String add(@PathVariable int a, @PathVariable int b)
	{
		return a+b + "";
	}
	
	@RequestMapping(path="/multi/{a}/{b}")
	public String multi(@PathVariable int a, @PathVariable int b)
	{
		
		return a * b + "";
	}
	
	@RequestMapping(path="/memberadd/{a}/{b}")
	public String memberMulti(@PathVariable int a, @PathVariable int b)
	{
		MathMember testMath = new MathMember(a, b);
		
		return testMath.add();
	}
	
	
 
 
}
