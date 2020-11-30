package org.ss;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.ss.restcontrollers.MainRestController;

@SpringBootTest
class SmokeTest {

	@Autowired
	private MainRestController mainRestController;

	@Test
	void contextLoadsControllers() throws Exception {
		assertThat(mainRestController).isNotNull();
	}
}
