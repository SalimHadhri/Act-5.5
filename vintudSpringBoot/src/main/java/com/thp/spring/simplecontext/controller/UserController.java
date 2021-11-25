package com.thp.spring.simplecontext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thp.spring.simplecontext.dto.UserDto;
import com.thp.spring.simplecontext.service.UserService;


@RestController
@RequestMapping("/userManagement")
public class UserController {



	
	@Autowired
	public UserService userService ;

	
	@PostMapping(value = "/addUser")
	public  UserDto addUser(@RequestBody UserDto userDto) {

		return userService.addUser(userDto) ;

	}

	@GetMapping(value = "/ListAllUser")
	public List<UserDto> findAllUsers() {


		return  userService.findAllUser();

	}

	@GetMapping(value = "/findUser/{id}")
	public UserDto findUserById(@PathVariable Long id) {
		return userService.findUserById(id) ;

	}

	@DeleteMapping(value = "/deleteUser/{id}")
	public UserDto delete(@PathVariable Long id) {
		return userService.deleteUser(id) ;
	}

	@PutMapping(value = "/updateUser/{id}")
	public UserDto updateUserById(@PathVariable Long id, @RequestBody UserDto userDto) 
			{

		return userService.updateUser(id, userDto) ;

	}


	

}
