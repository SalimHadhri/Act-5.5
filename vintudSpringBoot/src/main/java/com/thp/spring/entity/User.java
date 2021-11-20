package com.thp.spring.entity;




import java.io.Serializable;
import java.lang.reflect.Array; 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "`user`")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser ;
	
	
	
    
	private String firstname ;
	private String name ;
	private String pseudo  ;
	private String mail ;
	private String u_password  ;
	private String phone ;
	private String address  ;
	
	
    @ManyToOne
    private Role role ;

    
	
    @OneToMany(mappedBy="userRecherche")
    private Collection<Recherche> recherches ;
	
	
    @OneToMany(mappedBy="userAnnouncement")
    private Collection<Announcement> annoncementsUser ;
    
    @OneToMany(mappedBy="userFavori")
    private Collection<Favoris> favorisUser ;
    
    
    
    
	public User() {
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








	public Role getRole() {
		return role;
	}














	public void setRole(Role role) {
		this.role = role;
	}














	public User(Long id_user, String firstname, String name, String pseudo, String mail, String u_password, String phone,
			String address, Role role) {
		this.idUser = id_user;
		this.firstname = firstname;
		this.name = name;
		this.pseudo = pseudo;
		this.mail = mail;
		this.u_password = u_password;
		this.phone = phone;
		this.address = address;
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







	@Override
	public String toString() {
		return "User [id_user=" + idUser + ", firstname=" + firstname + ", name=" + name + ", pseudo=" + pseudo
				+ ", mail=" + mail + ", u_password=" + u_password + ", phone=" + phone + ", address=" + address
				+ ", role=" + role + ", recherches=" + recherches + ", annoncementsUser=" + annoncementsUser
				+ ", favorisUser=" + favorisUser + "]";
	}







	public static long getSerialversionuid() {
		return serialVersionUID;
	}

















	
	
}
