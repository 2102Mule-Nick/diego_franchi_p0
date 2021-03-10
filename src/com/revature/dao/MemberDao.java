package com.revature.dao;

import java.util.List;

import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.Member;

public interface MemberDao {
	
	public boolean createMember(Member memb) throws UserNameTaken;
	
	public Member getMemberByUsername(String username) throws UserNotFound;
	
	public List<Member> getAllMembers();
	
	public void updateMember(Member memb);
	
	public boolean removeMember(Member memb);

}
