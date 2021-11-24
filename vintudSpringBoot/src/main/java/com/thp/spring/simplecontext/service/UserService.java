package com.thp.spring.simplecontext.service;

import java.util.ArrayList;

import com.thp.spring.simplecontext.entity.User;

public interface UserService {

	public int creerUnCompte(User user);

	public User chooseUserSpecifications();

	public void afficherRoles();

	public User connectAccount(String email, String pwd);

	public void modificationInformationsPersonnelles(String email, String pwd);

	public void afficherUtilisateurs();

	public ArrayList<User> findAllUsers();

	public int findIdRoleByName(String name);

	public boolean emailExist(String email);

}
