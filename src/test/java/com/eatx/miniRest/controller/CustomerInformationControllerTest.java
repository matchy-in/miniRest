package com.eatx.miniRest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

import com.eatx.miniRest.model.CustomerInformation;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerInformationControllerTest {

	CustomerInformationController customerInformationController;
	
	@BeforeAll
	public void setup() {
		customerInformationController = mock(CustomerInformationController.class);
	}
	
	@Test
	public void getCustomerInformationByCustomerRef(){
//		when(customerInformationController.getCustomerInformationByCustomerRef("CR1")).thenReturn("{\"customerRef\":\"customerRef\",\"customerName\":\"customerName\"}");
//		assertEquals(customerInformationController.getCustomerInformationByCustomerRef("CR1"), "{\"customerRef\":\"customerRef\",\"customerName\":\"customerName\"}");
	}

	@Test
	public void postCustomerInformation(){
		CustomerInformation customerInformation = new CustomerInformation();
		customerInformation.setCustomerRef("CR6");
		customerInformation.setCustomerName("Gary Cox");
		customerInformation.setAddressLine1("100 St Mary St");
		customerInformation.setAddressLine2("");
		customerInformation.setTown("Weymouth");
		customerInformation.setCounty("Dorset");
		customerInformation.setCountry("United Kingdom");
		customerInformation.setPostCode("DT4 8NY");
		
//		when(customerInformationController.postCustomerInformation(customerInformation)).thenReturn("{\"result\":\"success\",\"customerId\":\"6\"}");
//		assertEquals(customerInformationController.postCustomerInformation(customerInformation), "{\"result\":\"success\",\"customerId\":\"6\"}");
	}
}
