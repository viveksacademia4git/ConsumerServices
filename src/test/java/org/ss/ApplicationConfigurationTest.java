package org.ss;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes=ApplicationConfiguration.class)
class ApplicationConfigurationTest {

	@Autowired
    private RestTemplate restTemplate;

	@Test
	void testGetRestTemplate() {
		assertNotNull(restTemplate, "Rest Template should not be null.");
	}

}
