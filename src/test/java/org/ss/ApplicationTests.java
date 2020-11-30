package org.ss;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.ss.Application;

@ExtendWith(SpringExtension.class)
class ApplicationTests {

	@Test
	void contextLoads() {
		Application.main(new String[] {});
		assertTrue(true);
	}

}
