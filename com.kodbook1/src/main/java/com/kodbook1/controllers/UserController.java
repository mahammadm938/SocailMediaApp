package com.kodbook1.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kodbook1.entitites.Post;
import com.kodbook1.entitites.User;
import com.kodbook1.services.PostService;
import com.kodbook1.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	PostService postService;
	
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
			@RequestParam String password,Model model, HttpSession session ) {
		boolean status=service.validateUser(username , password);
		
		if(status==true) {
			List<Post> allPosts=postService.fetchAllPosts();
			
			//Taking the username from the frontend 
			session.setAttribute("username", username);
			model.addAttribute("session", session);
			
			//Displaing the all posts of the user
			model.addAttribute("allPosts",allPosts);
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
			@RequestParam String linkedIn,@RequestParam String gitHub,@RequestParam MultipartFile profilePic,
			HttpSession session,Model model, @RequestParam String college) {
//		System.out.println(dob +","+bio+","+gender+","+city+","+linkedIn+","
//				+gitHub+","+profilePic);
		String username=(String) session.getAttribute("username");
		
		//fetch user object using username
		User user=service.getUser(username);
		
		//update and save object
		user.setDob(dob);
		user.setGender(gender);
		user.setCity(city);
		user.setBio(bio);
		user.setCollege(college);
		user.setLinkedIn(linkedIn);
		user.setGitHub(gitHub);
		try {
			user.setProfilePic(profilePic.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.updateUser(user);
		model.addAttribute("user", user);
		return "myProfile";
	}
}
