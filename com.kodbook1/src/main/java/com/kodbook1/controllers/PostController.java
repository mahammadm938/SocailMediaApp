package com.kodbook1.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kodbook1.entitites.Post;
import com.kodbook1.services.PostService;

@Controller
public class PostController {
	
	@Autowired
	PostService service;
	 
	@PostMapping("/createPost")
	public String createPost(@RequestParam("caption") String caption,
			@RequestParam("photo") MultipartFile photo) throws IOException {
		
		Post post= new Post();
	    post.setCaption(caption);
	    post.setPhoto(photo.getBytes());
	    
	    service.createPost(post);
	    return "home";
	    
		
	}

}
