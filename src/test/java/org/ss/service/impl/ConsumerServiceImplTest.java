package org.ss.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.ResponseEntity.ok;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import org.ss.model.Feed;

@ExtendWith(MockitoExtension.class)
class ConsumerServiceImplTest {

	@InjectMocks
	private ConsumerServiceImpl consumerService;

	@Mock
	private RestTemplate restTemplate;

	@Test
	void testConsumedFeeds() throws IOException {
		final String file = "testdata/Test_XKCD_0.json";
		try (var stream = ConsumerServiceImplTest.class.getClassLoader().getResourceAsStream(file)) {
			final String data = IOUtils.toString(stream, StandardCharsets.UTF_8).trim();
			when(restTemplate.getForEntity("https://xkcd.com/info.0.json", String.class))
					.thenReturn(ok().contentType(APPLICATION_JSON).body(data));
		}
		final List<Feed> feedList = consumerService.consumedFeeds();
		final List<Feed> expectedFeeds = List
				.of(new Feed("Life Before the Pandemic", new GregorianCalendar(2020, 10, 27).getTime(),
						"https://imgs.xkcd.com/comics/life_before_the_pandemic.png", "https://xkcd.com/info.0.json"));
		assertEquals(expectedFeeds, feedList);
	}

}
