package com.kodbook1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodbook1.entitites.Post;
import com.kodbook1.entitites.User;
import com.kodbook1.services.PostService;
import com.kodbook1.services.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class NavigationController {
	@Autowired
	PostService postService;
	
	@Autowired
	UserService service;
	
	
	//Navigation to open  the index page
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//Navigation for creating the posts
	@GetMapping("/openSignUp")
	public String openSignUp() {
		return "signUp";
	}
	@GetMapping("/openCreatePost")
	public String openCreatePost() {
		return "createPost";
	}
	
	//Navigation for showing the allPosts at a time 
	@GetMapping("/goHome")
	public String login(Model model)	{
			List<Post> allPosts = postService.fetchAllPosts();
			model.addAttribute("allPosts", allPosts);
			return "home";
	}
	//Navigation for opening the profile 
	@GetMapping("/openMyProfile")
	public String openMyProfile(Model model, HttpSession session) {
		String username= (String) session.getAttribute("username");
		User user=service.getUser(username);
		model.addAttribute("user", user);
		return "myProfile";
	}

	//Navigation for editing the Profile 
	@GetMapping("/openEditProfile")
	public String openEditProfile() {
		return "editProfile";
	}
	
}