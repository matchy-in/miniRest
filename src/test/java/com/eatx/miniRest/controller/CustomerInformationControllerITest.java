package com.eatx.miniRest.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerInformationControllerITest {

	@Autowired
	CustomerInformationController customerInformationController;

	@BeforeAll
	public void insertTestRecord() {
	}
	
	@Test
	public void getCustomerInformationByCustomerRef(){
		
	}

	@Test
	public void postCustomerInformation(){
		
	}
	
	@AfterAll
	public void deleteTestRecord() {
	}
	
}
