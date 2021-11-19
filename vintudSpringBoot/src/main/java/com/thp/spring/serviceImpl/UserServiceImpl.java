package com.thp.spring.serviceImpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.thp.spring.entity.User;
import com.thp.spring.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Override
	public int creerUnCompte(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User chooseUserSpecifications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afficherRoles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User connectAccount(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificationInformationsPersonnelles(String email, String pwd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherUtilisateurs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findIdRoleByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean emailExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
