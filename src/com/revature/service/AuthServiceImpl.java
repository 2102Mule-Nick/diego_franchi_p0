package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.MemberDao;
import com.revature.exception.InvalidPassword;
import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.Member;

public class AuthServiceImpl implements AuthService {
	
	Logger log = Logger.getRootLogger();
	
	private MemberDao memberDao;

	public AuthServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthServiceImpl(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	public MemberDao getUserDao() {
		return memberDao;
	}

	public void setUserDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public boolean isExistingMember(String username) {
		try {
			if (memberDao.getMemberByUsername(username) != null) {
				log.info("getUserByUsername did not return null");
				return true;
			}
		} catch (UserNotFound e) {
			return false;
		}
		return false;
	}

	@Override
	public Member authenticateMember(Member user) throws InvalidPassword, UserNotFound {
		
		Member existingUser = memberDao.getMemberByUsername(user.getUsername());

		if (existingUser.getSecretword().equals(user.getSecretword())) {
			return existingUser;
		}

		throw new InvalidPassword();
	}

	@Override
	public Member registerMember(Member user) throws UserNameTaken {
		log.trace("AuthServiceImpl.registerUser method called");
		memberDao.createMember(user);
		return user;
	}
	
	@Override
	public Member updateMember(Member user) {
		// TODO Auto-generated method stub
		log.info("Update User in Auth Service called");
		memberDao.updateMember(user);
		return null;
	}
	
	public boolean removeMember(Member memb) {

		if (isExistingMember(memb.getUsername())) {
			memberDao.removeMember(memb);
			return true;
		}
		return false;
	}
	
	public List<Member> getAllMembers() {
		log.info("getAllMembers in AuthServiceImpl called");
		return memberDao.getAllMembers();
	}
	
	public String getMemberIdFromUsername(String username) throws UserNotFound {
		
		if (isExistingMember(username)) {
			return String.valueOf(memberDao.getMemberByUsername(username).getMemberId());
		}
		
		throw new UserNotFound();
	}
	
//	public String getUsernameFromMemberId(int memberId) {
//		
//		if (isExistingMember(username)) {
//			return String.valueOf(memberDao.getMemberByUsername(username).getMemberId());
//		}
//		
//		throw new UserNotFound();
//	}

}
