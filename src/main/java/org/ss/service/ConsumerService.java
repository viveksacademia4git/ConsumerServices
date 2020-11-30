package org.ss.service;

import java.util.List;

import org.json.JSONObject;
import org.ss.model.Feed;
import org.ss.restcontrollers.MainRestController;
import org.ss.service.impl.ConsumerServiceImpl;

/**
 * Abstract interface with functions to fetch the feeds from remote services.
 * 
 * @author Vivek Yadav
 * @created 30 Nov 2020
 * 
 * @see ConsumerServiceImpl
 * @see MainRestController
 */
public interface ConsumerService {

	/**
	 * Perform processes before starting feed consumption process.
	 */
	void preFeeds();

	/**
	 * Consumes data from 'https://xkcd.com/json.html' and returns the data
	 * formatted within {@link List} of {@link Feed}. Feeds provided by the host
	 * services are available in JSON format, therefore the required values are
	 * copied into {@link JSONObject}.
	 * 
	 * @return list {@link List} of {@link Feed}
	 */
	List<Feed> feedsFromXKCD();

	/**
	 * Consumes data from 'http://feeds.feedburner.com/PoorlyDrawnLines' and returns
	 * the data formatted within {@link List} of {@link Feed}. Feeds provided by the
	 * host services are available in XML format, thus the feeds are parsed to JSON
	 * format and then copied into {@link JSONObject}.
	 * 
	 * @return list {@link List} of {@link Feed}
	 */
	List<Feed> feedsFromPoorlyDrawnLines();

}
