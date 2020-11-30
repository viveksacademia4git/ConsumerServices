package org.ss.model;

import java.util.Comparator;
import java.util.Date;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Model for holding feed values.
 * 
 * @author Vivek Yadav
 * @created 30 Nov 2020
 */
@Data
@RequiredArgsConstructor
public class Feed {

	@NonNull
	private String title;

	@NonNull
	private Date date;

	@NonNull
	private String browserviewlink;

	@NonNull
	private String picturelink;

	/**
	 * Comparator implementation for sorting the feeds according to the latest date.
	 * 
	 * @return comparisonInt
	 */
	// TODO -> Write Unit Test
	public static Comparator<Feed> feedComparator() {
		return (feed1, feed2) -> {
			final long time1 = feed1.getDate().getTime();
			final long time2 = feed2.getDate().getTime();
			if (time1 == time2) {
				return 0;
			}
			return time1 > time2 ? -1 : 1;
		};
	}
}
