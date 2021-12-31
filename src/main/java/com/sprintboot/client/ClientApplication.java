package com.sprintboot.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		int taskTimestamp = 555;
		log.info("starts run() taskTimestamp={}",taskTimestamp);
		SpringApplication.run(ClientApplication.class, args);
	}

}
