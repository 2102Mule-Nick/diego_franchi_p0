package com.revature.service;

import java.util.List;

import com.revature.exception.InvalidPassword;
import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.Member;

public interface AuthService {
	
	public boolean isExistingMember(String username);
	
	public Member authenticateMember(Member memb) throws InvalidPassword, UserNotFound;
	
	public Member registerMember(Member memb) throws UserNameTaken;

	public Member updateMember(Member memb);
	
	public List<Member> getAllMembers();
	
	public boolean removeMember(Member memb);

}
