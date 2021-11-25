package com.thp.spring.simplecontext.dto;

import java.io.Serializable;
import java.util.Collection;

import com.thp.spring.simplecontext.entity.Announcement;
import com.thp.spring.simplecontext.entity.Favoris;
import com.thp.spring.simplecontext.entity.Recherche;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idUser;

	private String firstname;
	private String name;
	private String pseudo;
	private String mail;
	private String password;
	private String phone;
	private String address;

	private String roleUser;

	private Collection<Recherche> recherches;

	private Collection<Announcement> annoncementsUser;

	private Collection<Favoris> favorisUser;

	public UserDto() {
	}



	public String getFirstname() {
		return firstname;
	}




	public UserDto(Long idUser, String firstname, String name, String pseudo, String mail, String password,
			String phone, String address, String roleUser, Collection<Recherche> recherches,
			Collection<Announcement> annoncementsUser, Collection<Favoris> favorisUser) {
		this.idUser = idUser;
		this.firstname = firstname;
		this.name = name;
		this.pseudo = pseudo;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.roleUser = roleUser;
		this.recherches = recherches;
		this.annoncementsUser = annoncementsUser;
		this.favorisUser = favorisUser;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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




	public String getRoleUser() {
		return roleUser;
	}



	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
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


	
	

}