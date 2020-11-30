package org.ss.restcontrollers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ss.model.Feed;

/**
 * Main REST controller.
 * 
 * @author Vivek Yadav
 * @created 30 Jul 2020
 */
@RestController
public class MainRestController {

	@GetMapping("/")
	public List<Feed> base() {
		return List.of(new Feed("picturelink", "title", "browserviewlink", new Date()));
	}

}
