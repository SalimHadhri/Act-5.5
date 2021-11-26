package com.thp.spring.simplecontext.entity;

//first request we will send this model in the post method as json body
public class LoginViewModel {

	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LoginViewModel(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public LoginViewModel() {
	}

}
