package com.thp.spring.dto;


public class UserDto {

	

	private Long idUser ;
	
	
	
    
	private String firstname ;
	private String name ;
	private String pseudo  ;
	private String mail ;
	private String u_password  ;
	private String phone ;
	private String address  ;
	


    
    
    
    
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
				+ ", mail=" + mail + ", u_password=" + u_password + ", phone=" + phone + ", address=" + address + "]";
	}



	
	
}
