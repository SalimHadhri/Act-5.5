package com.thp.spring.simplecontext.dto;

import java.util.Collection;

import com.thp.spring.simplecontext.entity.Announcement;
import com.thp.spring.simplecontext.entity.Favoris;
import com.thp.spring.simplecontext.entity.Recherche;
import com.thp.spring.simplecontext.entity.Role;

public class UserDto {

	private Long idUser;

	private String firstname;
	private String name;
	private String pseudo;
	private String mail;
	private String u_password;
	private String phone;
	private String address;
	
	
	private Role role;
	
	private Collection<Recherche> recherches;
	private Collection<Announcement> annoncementsUser;
	private Collection<Favoris> favorisUser;


	public UserDto() {
	}

	public Long getId_user() {
		return idUser;
	}

	public void setId_user(Long id_user) {
		this.idUser = id_user;
	}

	public String getFirstname() {
		return firstname;
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

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}



	@Override
	public String toString() {
		return "UserDto [idUser=" + idUser + ", firstname=" + firstname + ", name=" + name + ", pseudo=" + pseudo
				+ ", mail=" + mail + ", u_password=" + u_password + ", phone=" + phone + ", address=" + address
				+ ", role=" + role + ", recherches=" + recherches + ", annoncementsUser=" + annoncementsUser
				+ ", favorisUser=" + favorisUser + "]";
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public UserDto(Long idUser, String firstname, String name, String pseudo, String mail, String u_password,
			String phone, String address, Role role, Collection<Recherche> recherches,
			Collection<Announcement> annoncementsUser, Collection<Favoris> favorisUser) {
		this.idUser = idUser;
		this.firstname = firstname;
		this.name = name;
		this.pseudo = pseudo;
		this.mail = mail;
		this.u_password = u_password;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.recherches = recherches;
		this.annoncementsUser = annoncementsUser;
		this.favorisUser = favorisUser;
	}

	
	
}