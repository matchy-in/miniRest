package com.eatx.miniRest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
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

		File customerInformationCsvFile = new File(miniRestProperties.getCustomerInformationCsv());
		if (!customerInformationCsvFile.exists()) {
			throw new IOException("Customer Information CSV File does not exists");
		}
		
		List<String> customerInformationCsv = new ArrayList<String>();
		try {
			customerInformationCsv = FileUtils.readLines(customerInformationCsvFile, StandardCharsets.UTF_8);
			
			
		} catch (IOException e) {
		}
	}
}
