package org.ss.restcontrollers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ss.model.Feed;
import org.ss.service.ConsumerService;

/**
 * Main REST controller.
 * 
 * @author Vivek Yadav
 * @created 30 Nov 2020
 */
@RestController
public class MainRestController {

	@Autowired
	private ConsumerService consumerService;


	@GetMapping("/")
	public Map<String, Object> baseUrl() {
		this.consumerService.preFeeds();

		// Could run 'feedsFromXKCD' and 'feedsFromPoorlyDrawnLines' in parallel fashion
		final List<Feed> feedsXKCD = this.consumerService.feedsFromXKCD();
		final List<Feed> feedsPoorlyDrawnLines = this.consumerService.feedsFromPoorlyDrawnLines();

		if (feedsXKCD.isEmpty() && feedsPoorlyDrawnLines.isEmpty()) {
			return Map.of("status", "error", "message", "No feeds exist", "data", List.of());
		}

		feedsPoorlyDrawnLines.addAll(feedsXKCD);
		feedsPoorlyDrawnLines.sort(Feed.feedComparator());

		final String message = String.format("Number of feed: %d", feedsPoorlyDrawnLines.size());
		return Map.of("status", "success", "message", message, "data", feedsPoorlyDrawnLines);
	}

}
