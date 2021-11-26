package com.thp.spring.simplecontext.service;

import java.util.List;

import com.thp.spring.simplecontext.dto.UserDto;

public interface UserService {

	public UserDto addUser(UserDto userDto);
	
	public UserDto deleteUser(Long id) ;
	
	public UserDto findUserById (Long id) ;
	
	public List<UserDto> findAllUser() ;
	
	public UserDto updateUser(Long id , UserDto userDto) ;
	
	public UserDto findByUsername(String username) ;
	
	

}
