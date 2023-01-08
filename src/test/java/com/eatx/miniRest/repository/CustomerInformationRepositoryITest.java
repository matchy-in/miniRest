package com.eatx.miniRest.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerInformationRepositoryITest {

	@Autowired
	CustomerInformationRepository customerInformationRepository;
	
	@BeforeAll
	public void setup() {
	}
	
	@Test
	public void findByCustomerRef() {
		
	}
	
	@Test
	public void save() {
		
	}
	
	@AfterAll
	public void deleteTestRecord() {
	}
}
