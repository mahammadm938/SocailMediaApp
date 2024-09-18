package com.kodbook1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kodbook1.entitites.User;
import com.kodbook1.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/signUp")
	public String addUser (@ModelAttribute User user) {
		
		//user Exists?
		String username=user.getUsername();
		String email =user.getEmail();
		boolean status=service.userExists(username, email);
		if(status==false) {
			service.addUser(user);
		}
		return "index";
		
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, 
			@RequestParam String password) {
		boolean status=service.validateUser(username , password);
		if(status==true) {
			return "home";
		}
				return "index";	
	}
	
	@PostMapping("/forgotPassword")
	public String forgotPassword() {
		return null;
		
	}
	@PostMapping("/updateProfile")
	public String updateProfile(@RequestParam String dob, @RequestParam String bio,
			@RequestParam String gender,@RequestParam String city,
			@RequestParam String linkedIn,@RequestParam String gitHub,@RequestParam MultipartFile profilePic) {
		System.out.println(dob +","+bio+","+gender+","+city+","+linkedIn+","
				+gitHub+","+profilePic);
		return "myProfile";
	}
}
