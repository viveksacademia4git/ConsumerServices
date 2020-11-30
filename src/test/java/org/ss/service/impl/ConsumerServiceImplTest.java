package org.ss.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_XML;
import static org.springframework.http.ResponseEntity.ok;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import org.ss.model.Feed;

@ExtendWith(MockitoExtension.class)
class ConsumerServiceImplTest {

	@InjectMocks
	private ConsumerServiceImpl consumerService;

	@Mock
	private RestTemplate restTemplate;

	@BeforeEach
	public void setup() {
		ReflectionTestUtils.setField(consumerService, "countXKCD", 1);
	}

	@Test
	void testFeedsFromXKCD() throws IOException {
		final String file = "testdata/Test_XKCD_0.json";
		try (var stream = ConsumerServiceImplTest.class.getClassLoader().getResourceAsStream(file)) {
			final String data = IOUtils.toString(stream, StandardCharsets.UTF_8).trim();
			when(restTemplate.getForEntity("https://xkcd.com/1/info.0.json", String.class))
					.thenReturn(ok().contentType(APPLICATION_JSON).body(data));
		}
		final List<Feed> feedList = consumerService.feedsFromXKCD();
		final List<Feed> expectedFeeds = List
				.of(new Feed("Barrel - Part 1", new GregorianCalendar(2006, 0, 1).getTime(),
						"https://xkcd.com/1/info.0.json", "https://imgs.xkcd.com/comics/barrel_cropped_(1).jpg"));
		assertEquals(expectedFeeds, feedList);
	}

	@Test
	void testFeedsFromPoorlyDrawnLines() throws IOException {
		final String file = "testdata/Test_PoorlyDrawnLines.xml";
		try (var stream = ConsumerServiceImplTest.class.getClassLoader().getResourceAsStream(file)) {
			final String data = IOUtils.toString(stream, StandardCharsets.UTF_8).trim();
			when(restTemplate.getForEntity("http://feeds.feedburner.com/PoorlyDrawnLines", String.class))
					.thenReturn(ok().contentType(APPLICATION_XML).body(data));
		}
		final List<Feed> feedList = consumerService.feedsFromPoorlyDrawnLines();
		assertEquals(10, feedList.size(), "Number of feeds should be 10");
		final Feed expected = new Feed("Business Shorts", new GregorianCalendar(2020, 10, 23, 19, 14, 47).getTime(),
				"http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/bn7cSaaRN-0/",
				"http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/Business-shorts.png");
		assertEquals(expected, feedList.get(0), "First feed should match with the expected feed");
	}

}
