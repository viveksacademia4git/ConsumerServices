package org.ss.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.ss.model.Feed;
import org.ss.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	private static final Logger log = LoggerFactory.getLogger(ConsumerServiceImpl.class);

	@Override
	public List<Feed> consumedFeeds() {
		log.info("Consuming feeds...");
		return List.of(new Feed("picturelink", "title", "browserviewlink", new Date()));
	}

}
