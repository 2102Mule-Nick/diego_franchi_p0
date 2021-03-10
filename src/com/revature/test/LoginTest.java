package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.esotericsoftware.kryo.Kryo;
import com.revature.dao.MemberDao;
import com.revature.dao.MemberDaoKryo;
import com.revature.exception.InvalidPassword;
import com.revature.exception.UserNotFound;
import com.revature.pojo.Member;
import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;

public class LoginTest {
	
	private Logger log = Logger.getRootLogger();
	
	private static MemberDao memberDao;
	
	private static AuthService authService;
	
	@BeforeEach
	private void setUp() {
		memberDao = new MemberDaoKryo();
		authService = new AuthServiceImpl(memberDao);
	}
	
//	@AfterEach
//	private void tearDown() {
//		ItemInventory.getItemList().clear();
//		item = null;
//	}

	@Test
	void kryoLogin() throws InvalidPassword, UserNotFound {
		Member user = new Member();
		user.setUsername("noob");
		user.setSecretword("password123");
		assertNotNull(authService.authenticateMember(user), "user was authenticated through login menu and serialization");
	}

	
//	@Test
//	void itemIsAddedToCart() throws OutOfStockException {
		
//		//AAA Pattern for testing
//		
//		//Arrange
//		Cart cart = new Cart();
//		
//		//Act
//		service.addItem(1, 1, cart);
//		
//		//Assert
//		assertEquals("Cart should have 1 item in it", 1, cart.getItems().size());
//		
//	}
	
//	@Test
//	void addMoreItemsThanQuantity() {
		
//		//Arrange
//		Cart cart = new Cart();
//		
//		//Act
//		assertThrows(OutOfStockException.class, () -> {service.addItem(1, 5, cart);});
//		
//		//Assert
//		assertEquals("Make sure no items were added", 0, cart.getItems().size());
		
//	}

}
