package org.ss.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ss.model.Feed;

@ExtendWith(MockitoExtension.class)
class ConsumerServiceImplTest {

	@InjectMocks
	private ConsumerServiceImpl consumerService;

	@Test
	void testConsumedFeeds() {
		final List<Feed> feedList = consumerService.consumedFeeds();
		assertNotNull(feedList);
	}

}
