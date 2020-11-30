package org.ss;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Application's configuration file.
 * 
 * @author Vivek Yadav
 * @created 30 Nov 2020
 */
public class ApplicationConfiguration {

	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}