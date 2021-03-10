package com.revature.test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.dao.MemberDao;
import com.revature.dao.MemberDaoPostgres;
import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.Member;
import com.revature.util.ConnectionFactoryPostgres;

public class MemberDaoTest {
	
	@BeforeEach
	private void setUp() {
	}
	
	@Test
	void createMemberTest() throws UserNameTaken {
		
		MemberDao memberDao = new MemberDaoPostgres();
		Member user = new Member("test2","test123");
		
		assertTrue(memberDao.createMember(user), "Creating SQL row in DATE db");
	}
	
	@Test
	void getMemberByUsernameTest( ) throws UserNotFound {
		
		MemberDao memberDao = new MemberDaoPostgres();
		
		assertEquals("Diego", memberDao.getMemberByUsername("Diego").getUsername());
		
	}
	
	@Test
	void removeMemberTest() {
		MemberDao memberDao = new MemberDaoPostgres();
		Member memb = new Member("test2","test123");
		
		assertTrue(memberDao.removeMember(memb), "Remove SQL row in DATE db");
	}
	
	@Test
	void getAllMembersTest() {
		MemberDao memberDao = new MemberDaoPostgres();
		assertNotNull(memberDao.getAllMembers());
	}

}
