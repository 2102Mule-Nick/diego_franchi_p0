package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.util.ConnectionFactoryPostgres;

public class ConnectionFactoryTest {
	
	@BeforeEach
	private void setUp() {
	}
	
	@Test
	void factoryCreationTest() {
		
		assertNotNull(ConnectionFactoryPostgres.getConnection(), "Connection to DB should be created.");
		
	}
}
