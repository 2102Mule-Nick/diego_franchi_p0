package com.revature.pojo;

import java.util.List;

public class User {

	private String username;
	
	private String password;
	
	private String bio;
	
	private List<String> interests;
	
	private boolean male;
	
	private boolean straight;

	public User() {
		super();
	}
	
	public User(String username, String password, String bio, List interests) {
		super();
		this.username = username;
		this.password = password;
		this.bio = bio;
		this.interests = interests;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}
