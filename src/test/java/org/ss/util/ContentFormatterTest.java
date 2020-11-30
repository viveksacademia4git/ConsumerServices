package org.ss.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.GregorianCalendar;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.ss.model.Feed;

class ContentFormatterTest {

	@Test
	void testFormatXKCD() throws IOException {
		final String file = "testdata/Test_XKCD_0.json";
		try (var stream = ContentFormatterTest.class.getClassLoader().getResourceAsStream(file)) {
			final String data = IOUtils.toString(stream, StandardCharsets.UTF_8).trim();
			final Feed expected = new Feed("Life Before the Pandemic", new GregorianCalendar(2020, 10, 27).getTime(),
					"https://imgs.xkcd.com/comics/life_before_the_pandemic.png", "http://dummy.browserviewlink");
			assertEquals(expected, ContentFormatter.formatXKCD(data, "http://dummy.browserviewlink"));
		}
	}
}
