package com.thp.spring.simplecontext.dto;

import java.util.Collection;

import com.thp.spring.simplecontext.entity.User;

public class RoleDto {

	private Long idRole;

	private String nom;
	
	
	private Collection<User> usersRole;


	public RoleDto() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getRole_id() {
		return idRole;
	}

	public void setRole_id(Long role_id) {
		this.idRole = role_id;
	}

	public RoleDto(Long role_id, String nom) {
		this.idRole = role_id;
		this.nom = nom;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	@Override
	public String toString() {
		return "RoleDto [idRole=" + idRole + ", nom=" + nom + "]";
	}

	public Collection<User> getUsersRole() {
		return usersRole;
	}

	public void setUsersRole(Collection<User> usersRole) {
		this.usersRole = usersRole;
	}

	public RoleDto(Long idRole, String nom, Collection<User> usersRole) {
		this.idRole = idRole;
		this.nom = nom;
		this.usersRole = usersRole;
	}
	
	

}