package org.ss.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.ss.model.Feed;
import org.ss.restcontrollers.MainRestController;
import org.ss.service.ConsumerService;
import org.ss.util.ContentFormatter;

/**
 * Implementation of {@link ConsumerService} that returns feeds.
 * 
 * @author Vivek Yadav
 * @created 30 Nov 2020
 * 
 * @see MainRestController
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

	private static final Logger log = LoggerFactory.getLogger(ConsumerServiceImpl.class);

	private @Value("${xkcd.count}") Integer countXKCD;

	@Autowired
	private RestTemplate restTemplate;

	private LinkedList<Feed> cacheXKCD = new LinkedList<>();
	private Integer indexTopXKCD = 10;
	private Feed feedTopXKCD = null;

	@Override
	public void preFeeds() {
		log.info("Initializing Consumer Feed Service...");
		final ResponseEntity<?> response = this.restTemplate.getForEntity("https://xkcd.com/info.0.json", String.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			final String responseContent = response.getBody().toString();
			final JSONObject json = new JSONObject(response.getBody().toString());
			this.indexTopXKCD = json.getInt("num");
			this.feedTopXKCD = ContentFormatter.formatXKCD(responseContent,
					String.format("https://xkcd.com/%d/info.0.json", this.indexTopXKCD));
		}
	}

	@Override
	public List<Feed> feedsFromXKCD() {
		final List<Feed> feedList = new ArrayList<>();
		int index = this.indexTopXKCD.intValue();
		if (!cacheXKCD.isEmpty() && cacheXKCD.getFirst().equals(feedTopXKCD)) {
			feedList.addAll(cacheXKCD);
			return feedList;
		}
		this.cacheXKCD = new LinkedList<>();
		// Can use 'CyclicBarrier' here
		for (int i = 0; i < this.countXKCD.intValue(); i++, index--) {
			final String consumerEndpoint = String.format("https://xkcd.com/%d/info.0.json", index);
			log.info("Consuming feed from {}", consumerEndpoint);
			final ResponseEntity<?> response = this.restTemplate.getForEntity(consumerEndpoint, String.class);
			if (response.getStatusCode() == HttpStatus.OK) {
				final String responseContent = response.getBody().toString();
				final Feed feed = ContentFormatter.formatXKCD(responseContent, consumerEndpoint);
				feedList.add(feed);
				this.cacheXKCD.add(feed);
			}
		}
		return feedList;
	}

	@Override
	public List<Feed> feedsFromPoorlyDrawnLines() {
		final String consumerEndpoint = "http://feeds.feedburner.com/PoorlyDrawnLines";
		log.info("Consuming feed from {}", consumerEndpoint);
		final ResponseEntity<?> response = this.restTemplate.getForEntity(consumerEndpoint, String.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			final String responseContent = response.getBody().toString();
			return ContentFormatter.formatPoorlyDrawnLines(responseContent);
		}
		return new ArrayList<>();
	}

}
