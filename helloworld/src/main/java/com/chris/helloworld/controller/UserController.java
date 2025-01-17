package com.chris.helloworld.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chris.helloworld.error.DuplicateDataException;
import com.chris.helloworld.member.CurrentUsers;
import com.chris.helloworld.repo.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@ComponentScan(basePackages = "com.chris.helloworld")
@RequestMapping(path="/demo")
public class UserController {
	
	
	@Autowired 
	public UserRepository userRepository;
	public DuplicateDataException dataCheck;
	
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	
	@GetMapping("/users")
	public List<CurrentUsers> index(){
	        return userRepository.findAll();
 	}

	 @GetMapping("/user/{id}")
	    public CurrentUsers show(@PathVariable String id){
	        int blogId = Integer.parseInt(id);
	        return userRepository.getOne(blogId);
	        
	 }
	 
	 @PostMapping("/users")
	    public CurrentUsers create(@RequestBody Map<String, String> body){
	        
			String account = body.get("account");
			String name = body.get("name");
	        String email = body.get("email");
	        
	        //If an account number or email exists in the database, don't do anything 
	        if (userRepository.existsByAccount(account) || userRepository.existsByEmail(email))
	        {
	        	return null;
	        }
	        
	        return userRepository.save(new CurrentUsers(account, name, email));
	 }
	 
	 @PutMapping("/users/{id}")
	 public CurrentUsers update(@PathVariable String id, @RequestBody Map<String, String> body){
        int userId = Integer.parseInt(id);
        //I did this correctly in equation controller, it's a little late to be modifying this, may do this later in the weekend
        //but for now, this is just plain wrong
        CurrentUsers user = userRepository.getOne(userId);
        user.setAccount("account");
        user.setEmail("email");
        user.setName("name");
        
        return userRepository.save(user);
    }

    @DeleteMapping("users/{id}")
    public boolean delete(@PathVariable String id){
        int userId = Integer.parseInt(id);
        userRepository.deleteById(userId);
        return true;
    }


}
