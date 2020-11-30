package org.ss.service.impl;

import java.util.ArrayList;
import java.util.List;

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
 * @created 30 Jul 2020
 * 
 * @see MainRestController
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

	private static final Logger log = LoggerFactory.getLogger(ConsumerServiceImpl.class);

	private @Value("${xkcd.count}") Integer countXKCD;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Feed> feedsFromXKCD() {
		final List<Feed> feedList = new ArrayList<>();
		for (int i = 1; i <= this.countXKCD.intValue(); i++) {
			final String consumerEndpoint = String.format("https://xkcd.com/%d/info.0.json", i);
			log.info("Consuming feed from {}", consumerEndpoint);
			final ResponseEntity<?> response = this.restTemplate.getForEntity(consumerEndpoint, String.class);
			if (response != null && response.getStatusCode() == HttpStatus.OK) {
				final String responseContent = response.getBody().toString();
				feedList.add(ContentFormatter.formatXKCD(responseContent, consumerEndpoint));
			}
		}
		return feedList;
	}

	@Override
	public List<Feed> feedsFromPoorlyDrawnLines() {
		final String consumerEndpoint = "http://feeds.feedburner.com/PoorlyDrawnLines";
		log.info("Consuming feed from {}", consumerEndpoint);
		final ResponseEntity<?> response = this.restTemplate.getForEntity(consumerEndpoint, String.class);
		if (response != null && response.getStatusCode() == HttpStatus.OK) {
			final String responseContent = response.getBody().toString();
			return ContentFormatter.formatPoorlyDrawnLines(responseContent);
		}
		return List.of();
	}

}
