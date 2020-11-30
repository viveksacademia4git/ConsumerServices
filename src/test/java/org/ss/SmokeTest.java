package org.ss;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.ss.restcontrollers.MainRestController;
import org.ss.service.ConsumerService;

@SpringBootTest
class SmokeTest {

	@Autowired
	private MainRestController mainRestController;

	@Autowired
	private ConsumerService consumerService;

	@Test
	void contextLoadsControllers() throws Exception {
		assertNotNull(mainRestController);
	}

	@Test
	void contextLoadsServices() throws Exception {
		assertNotNull(consumerService);
	}
}
