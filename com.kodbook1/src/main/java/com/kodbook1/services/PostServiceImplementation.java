package com.kodbook1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook1.entitites.Post;
import com.kodbook1.repositories.PostRepository;



@Service
public class PostServiceImplementation implements PostService{
	
	@Autowired
	PostRepository repo;

	@Override
	public void createPost(Post post) {
		repo.save(post);
		
	}
	

}
