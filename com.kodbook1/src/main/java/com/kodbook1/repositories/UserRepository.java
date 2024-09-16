package com.kodbook1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodbook1.entitites.User;



public interface UserRepository extends JpaRepository <User, Long> {

	//except for primary key if we want to find by another parameters them we have to 
	//over ride in the UserRepository 
	User findByEmail(String email);

	User findByUsername(String username);

}
