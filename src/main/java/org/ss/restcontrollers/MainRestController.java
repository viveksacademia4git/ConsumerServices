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
 * @created 30 Jul 2020
 */
@RestController
public class MainRestController {

	@Autowired
	private ConsumerService consumerService;

	@GetMapping("/")
	public Map<String, Object> baseUrl() {
		final List<Feed> feedsXKCD = consumerService.feedsFromXKCD();
		final List<Feed> feedsPoorlyDrawnLines = consumerService.feedsFromPoorlyDrawnLines();
		if (feedsXKCD.isEmpty() && feedsPoorlyDrawnLines.isEmpty()) {
			return Map.of("status", "error", "message", "No feeds exist", "data", List.of());
		}
		feedsPoorlyDrawnLines.addAll(feedsXKCD);
		final String message = String.format("Number of feed: %d", feedsPoorlyDrawnLines.size());
		return Map.of("status", "success", "message", message, "data", feedsPoorlyDrawnLines);
	}

}
