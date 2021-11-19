package com.thp.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.thp.spring.entity.User;
import com.thp.spring.repository.UserRepository;

public class UserController {
	
	@Autowired
	UserRepository userRepository ;
	
	/*
	
	public ArrayList<User> getAllUsers() {		
		return userRepository.findAllUsers();	
	}
	
	public int findIdRoleByName(String name) {
		
		return userRepository.findIdRoleByName(name);
	}
	
	public int addUser( User user) {
		return userRepository.creerUnCompte(user);
	}*/
	

}
