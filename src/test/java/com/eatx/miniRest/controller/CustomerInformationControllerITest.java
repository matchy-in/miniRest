package com.eatx.miniRest.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eatx.miniRest.model.CustomerInformation;

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
	}
	
	@Test
	public void getCustomerInformationByCustomerRef(){
		customerInformationController.getCustomerInformationByCustomerRef("CR8");
	}
	
//	@AfterAll
	public void deleteTestRecord() {
		customerInformationController.deleteCustomerInformation(customerInformation.getCustomerId());
	}
	
}
