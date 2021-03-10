package com.revature.pojo;

import java.util.List;

public class Member {
	
	private int memberId;

	private String username = "";
	
	private String secretword = "";
	
	private int age;

	private String sex;
	
	private String location;
	
	private String bio;
	
	private List<String> interests;
	

	public Member() {
		super();
	}
	
	public Member(String username, String secretword) {
		super();
		this.username = username;
		this.secretword = secretword;
	}
	
	public Member(String username, String secretword, String bio, List interests) {
		super();
		this.username = username;
		this.secretword = secretword;
		this.bio = bio;
		this.interests = interests;
	}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSecretword() {
		return secretword;
	}

	public void setSecretword(String secretword) {
		this.secretword = secretword;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
		return  "User :  " + username +
				"\nAge : " + String.valueOf(age) + 
				"\nSex : " + sex +
				"\nLocation : " + location +
				"\nBio : " + bio;
	}
}
