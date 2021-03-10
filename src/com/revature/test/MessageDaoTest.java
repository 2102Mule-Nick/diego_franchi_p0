package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.dao.MessageDao;
import com.revature.dao.MessageDaoPostgres;
import com.revature.pojo.Message;

class MessageDaoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void sendMessageTest() {
		MessageDao messageDao = new MessageDaoPostgres();
		Message msg = new Message("2", "1", LocalDateTime.now(), "hello", "how are you?");
		assertTrue(messageDao.sendMessage(msg));
	}

}
