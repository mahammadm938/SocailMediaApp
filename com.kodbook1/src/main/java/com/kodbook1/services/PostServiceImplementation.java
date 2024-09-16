package com.kodbook1.services;

import java.util.List;

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

	@Override
	public List<Post> fetchAllPosts(){
		return repo.findAll();
	}

	@Override
	public List<Post> getAllPosts() {
		return repo.findAll();
	}

	
	

}
