package com.thp.spring.simplecontext.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.thp.spring.simplecontext.entity.Announcement;
import com.thp.spring.simplecontext.entity.Favoris;
import com.thp.spring.simplecontext.entity.Recherche;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idUser;

	private String username;
	private String pseudo;
	private String mail;
	private String password;
	private String phone;
	private String address;
	private int active;

	private String roles = "";
	private String permissions = "";

	private Collection<Recherche> recherches;

	private Collection<Announcement> annoncementsUser;

	private Collection<Favoris> favorisUser;

	public UserDto() {
	}



	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Recherche> getRecherches() {
		return recherches;
	}

	public void setRecherches(Collection<Recherche> recherches) {
		this.recherches = recherches;
	}

	public Collection<Announcement> getAnnoncementsUser() {
		return annoncementsUser;
	}

	public void setAnnoncementsUser(Collection<Announcement> annoncementsUser) {
		this.annoncementsUser = annoncementsUser;
	}

	public Collection<Favoris> getFavorisUser() {
		return favorisUser;
	}

	public void setFavorisUser(Collection<Favoris> favorisUser) {
		this.favorisUser = favorisUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPassword() {
		return password;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoleList() {
		if (this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<>();
	}

	public List<String> getPermissionList() {
		if (this.permissions.length() > 0) {
			return Arrays.asList(this.permissions.split(","));
		}
		return new ArrayList<>();
	}

	public UserDto(Long idUser, String username, String pseudo, String mail, String password,
			String phone, String address, int active, String roles, String permissions,
			Collection<Recherche> recherches, Collection<Announcement> annoncementsUser,
			Collection<Favoris> favorisUser) {
		this.idUser = idUser;
		this.username = username;
		this.pseudo = pseudo;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.active = active;
		this.roles = roles;
		this.permissions = permissions;
		this.recherches = recherches;
		this.annoncementsUser = annoncementsUser;
		this.favorisUser = favorisUser;
	}

}