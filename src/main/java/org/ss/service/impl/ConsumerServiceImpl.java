package org.ss.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.ss.model.Feed;
import org.ss.service.ConsumerService;
import org.ss.util.ContentFormatter;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	private static final Logger log = LoggerFactory.getLogger(ConsumerServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Feed> consumedFeeds() {
		final String consumerEndpoint = "https://xkcd.com/info.0.json";
		log.info("Consuming feed from {}", consumerEndpoint);
		final ResponseEntity<?> response = this.restTemplate.getForEntity(consumerEndpoint, String.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			final String responseContent = response.getBody().toString();
			return List.of(ContentFormatter.formatXKCD(responseContent, consumerEndpoint));
		}
		return List.of();
	}

}
