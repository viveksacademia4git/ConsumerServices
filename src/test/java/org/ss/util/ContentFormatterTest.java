package org.ss.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.ss.model.Feed;

class ContentFormatterTest {

	@Test
	void testFormatXKCD() throws IOException {
		final String file = "testdata/Test_XKCD_0.json";
		try (var stream = ContentFormatterTest.class.getClassLoader().getResourceAsStream(file)) {
			final String data = IOUtils.toString(stream, StandardCharsets.UTF_8).trim();
			final Feed expected = new Feed("Barrel - Part 1", new GregorianCalendar(2006, 0, 1).getTime(),
					"https://xkcd.com/1/info.0.json", "https://imgs.xkcd.com/comics/barrel_cropped_(1).jpg");
			assertEquals(expected, ContentFormatter.formatXKCD(data, "https://xkcd.com/1/info.0.json"));
		}
	}

	@Test
	void testFormatPoorlyDrawnLines() throws IOException {
		final String file = "testdata/Test_PoorlyDrawnLines.xml";
		try (var stream = ContentFormatterTest.class.getClassLoader().getResourceAsStream(file)) {
			final String data = IOUtils.toString(stream, StandardCharsets.UTF_8).trim();
			final List<Feed> feedList = ContentFormatter.formatPoorlyDrawnLines(data);
			assertEquals(10, feedList.size(), "Number of feeds should be 10");
			final Feed expected = new Feed("Business Shorts", new GregorianCalendar(2020, 10, 23).getTime(),
					"http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/bn7cSaaRN-0/",
					"http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/Business-shorts.png");
			assertEquals(expected, feedList.get(0), "First feed should match with the expected feed");
		}
	}
}
