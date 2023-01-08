package com.eatx.miniRest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MiniRestPropertiesTest {

	@Autowired
	private MiniRestProperties miniRestProperties;

	@Test
	public void testCustomerInformationCsvFileNotExists(){
		File customerInformationCsvFile = new File(miniRestProperties.getCustomerInformationCsv());
		assertTrue(customerInformationCsvFile.exists());
	}
	
	@Test
	public void testCustomerInformationCsvFileExists(){
		File customerInformationCsvFile = new File(miniRestProperties.getCustomerInformationCsv());

		List<String> customerInformationCsv = new ArrayList<String>();
		try {
			customerInformationCsv = FileUtils.readLines(customerInformationCsvFile, StandardCharsets.UTF_8);
		} catch (IOException e) {
		}
		assertEquals(5, customerInformationCsv.size());
	}
}
