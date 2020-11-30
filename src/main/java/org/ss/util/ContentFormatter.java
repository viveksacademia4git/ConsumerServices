package org.ss.util;

import java.util.Date;
import java.util.GregorianCalendar;

import org.json.JSONObject;
import org.ss.model.Feed;

public class ContentFormatter {

	private ContentFormatter() { }

	public static Feed formatXKCD(final String content, final String browserviewlink) {
		final JSONObject json = new JSONObject(content);
		final String title = json.getString("title");
		final int day = json.getInt("day");
		final int month = json.getInt("month") - 1;
		final int year = json.getInt("year");
		final Date date = new GregorianCalendar(year, month, day).getTime();
		final String picturelink = json.getString("img");
		return new Feed(title, date, picturelink, browserviewlink);
	}
}
