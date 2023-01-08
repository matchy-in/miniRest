package com.eatx.miniRest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eatx.miniRest.model.CustomerInformation;


/**
 * integration test of CustomerInformationController
 * @author match
 * @since 1.0
 */
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerInformationControllerITest {

	@Autowired
	CustomerInformationController customerInformationController;
	
	CustomerInformation customerInformation;

	@BeforeAll
	public void postCustomerInformation(){
		customerInformation = new CustomerInformation();
		
		customerInformation.setCustomerRef("CR8");
		customerInformation.setCustomerName("Gary Cox");
		customerInformation.setAddressLine1("100 St Mary St");
		customerInformation.setAddressLine2("");
		customerInformation.setTown("Weymouth");
		customerInformation.setCounty("Dorset");
		customerInformation.setCountry("United Kingdom");
		customerInformation.setPostCode("DT4 8NY");
		
		customerInformation = customerInformationController.postCustomerInformation(customerInformation);
		
		assertNotNull(customerInformation.getCustomerId());
	}
	
	@Test
	public void getCustomerInformationByCustomerRef(){
		CustomerInformation customerInformation = customerInformationController.getCustomerInformationByCustomerRef("CR8");
		
		assertNotNull(customerInformation);
	}
	
	@AfterAll
	public void deleteTestRecord() {
		assertEquals("{\"success\":true}",customerInformationController.deleteCustomerInformation(customerInformation.getCustomerId()));
	}
	
}
