package com.greenfoxacademy.reddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class RedditApp {

	public static void main(String[] args) {
		SpringApplication.run(RedditApp.class, args);
	}
}
