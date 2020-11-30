package org.ss.restcontrollers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.ui.Model;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MainRestControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * HTTP Test for {@link MainController#index(Model)}
	 * @throws Exception
	 */
	@Test
	final void testBase() throws Exception {
		final String url = String.format("http://localhost:%d/", this.port);
		assertThat(restTemplate.getForObject(url, String.class).trim()).contains("picturelink");
	}

}
