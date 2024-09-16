package com.kodbook1.services;

import java.util.List;

import com.kodbook1.entitites.Post;

public interface PostService {

	void createPost(Post post);
	

	List <Post> getAllPosts();
	
	List<Post> fetchAllPosts();

}
