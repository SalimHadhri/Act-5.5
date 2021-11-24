package com.thp.spring.simplecontext.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.thp.spring.simplecontext.repository.UserRepository;

public class UserController {

	@Autowired
	UserRepository userRepository;

	/*
	 * 
	 * public ArrayList<User> getAllUsers() { return userRepository.findAllUsers();
	 * }
	 * 
	 * public int findIdRoleByName(String name) {
	 * 
	 * return userRepository.findIdRoleByName(name); }
	 * 
	 * public int addUser( User user) { return userRepository.creerUnCompte(user); }
	 */

}
