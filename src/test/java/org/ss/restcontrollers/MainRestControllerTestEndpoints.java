package org.ss.restcontrollers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.ui.Model;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class MainRestControllerTestEndpoints {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * HTTP Test for {@link MainController#index(Model)}
	 * @throws Exception
	 */
	@Test
	final void testBaseUrl() throws Exception {
		final String url = String.format("http://localhost:%d/", this.port);
		assertThat(restTemplate.getForObject(url, String.class).trim()).contains(List.of("status", "message", "data"));
	}

}
