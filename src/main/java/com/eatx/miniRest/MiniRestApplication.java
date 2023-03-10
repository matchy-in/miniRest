package com.eatx.miniRest;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniRestApplication implements CommandLineRunner{

	static Log logger = LogFactory.getLog(MiniRestApplication.class);
	
	@Autowired
	private MiniRestProperties miniRestProperties;
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(MiniRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.debug("application startup");
	}
}
