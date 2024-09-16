package com.kodbook1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook1.entitites.User;
import com.kodbook1.repositories.UserRepository;


@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public boolean userExists(String username, String email) {
		User user1=repo.findByEmail(email);
		User user2=repo.findByUsername(username);
		if(user1!= null || user2!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void addUser(User user) {
	 repo.save(user);
		
	}

	@Override
	public boolean validateUser(String username, String password) {
		String dbPass=repo.findByUsername(username).getPassword();
		if(password.equals(dbPass)) {
			return true;
		}
		return false;
	}
	

}
