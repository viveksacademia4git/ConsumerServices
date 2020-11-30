package org.ss.restcontrollers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.ss.model.Feed;
import org.ss.service.ConsumerService;

@WebMvcTest(MainRestController.class)
class MainRestControllerTestIntegration {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ConsumerService consumerService;

	@Test
	void testBaseUrlWithFeed() throws Exception {
		final List<Feed> feeds = List.of(new Feed("picturelink", "title", "browserviewlink", new Date()));
		when(consumerService.consumedFeeds()).thenReturn(feeds);
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(Matchers.containsString("\"message\":\"No of feed: 1\"")));
	}

	@Test
	void testBaseUrlWithoutFeed() throws Exception {
		when(consumerService.consumedFeeds()).thenReturn(List.of());
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(Matchers.containsString("\"message\":\"No feeds exist\"")));
	}

}
