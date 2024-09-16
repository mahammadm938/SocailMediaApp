package com.kodbook1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodbook1.entitites.Post;



public interface PostRepository extends JpaRepository <Post, Long>{

}
