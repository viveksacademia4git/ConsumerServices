package org.ss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Application Class to execute the project using Spring Boot.
 * 
 * @author Vivek Yadav
 * @created 30 Nov 2020
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		log.info("Starting project as SpringBoot...");
		SpringApplication.run(Application.class, args);
	}

}
