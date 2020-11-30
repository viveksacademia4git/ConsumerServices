package org.ss.util;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ss.model.Feed;

public class ContentFormatter {

	private static final Logger log = LoggerFactory.getLogger(ContentFormatter.class);

	private ContentFormatter() {
	}

	public static Feed formatXKCD(final String jsonContent, final String browserviewlink) {
		final JSONObject json = new JSONObject(jsonContent);
		final String title = json.getString("title");
		final int day = json.getInt("day");
		final int month = json.getInt("month") - 1;
		final int year = json.getInt("year");
		final Date date = new GregorianCalendar(year, month, day).getTime();
		final String picturelink = json.getString("img");
		return new Feed(title, date, browserviewlink, picturelink);
	}

	public static List<Feed> formatPoorlyDrawnLines(final String xmlContent) {
		final JSONObject jsonConverted = XML.toJSONObject(xmlContent);
		final JSONArray itemArray = jsonConverted.getJSONObject("rss").getJSONObject("channel").getJSONArray("item");

		final DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		final List<Feed> feedList = new ArrayList<>();
		itemArray.forEach(item -> {
			final JSONObject json = (JSONObject) item;
			final String title = json.getString("title");
			final String strDate = json.getString("pubDate");
			final String picturelink = getImageUrl(json.getString("content:encoded"));
			final String browserviewlink = json.getString("link");
			try {
				final Calendar c = new GregorianCalendar();
				c.setTime(dateFormat.parse(strDate));
				final Date date = new GregorianCalendar(c.get(YEAR), c.get(MONTH), c.get(DAY_OF_MONTH)).getTime();
				log.info("Formatted Date ======>>>>>>> {}", date);
				feedList.add(new Feed(title, date, browserviewlink, picturelink));
			} catch (ParseException e) {
				log.error(String.format("An error occurred while parsing date: %s", strDate), e);
			}
		});

		return feedList;
	}

	private static String getImageUrl(final String htmlContent) {
		final Document document = Jsoup.parse(htmlContent.trim());
		return document.select("div").first().select("figure").first().select("img").first().attr("src");
	}
}
