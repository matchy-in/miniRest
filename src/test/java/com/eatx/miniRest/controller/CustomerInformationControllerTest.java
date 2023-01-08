package com.eatx.miniRest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eatx.miniRest.model.CustomerInformation;
import com.eatx.miniRest.repository.CustomerInformationRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerInformationControllerTest {

	@Autowired
	CustomerInformationController customerInformationController;
	
	//mock object
	CustomerInformationRepository customerInformationRepository;
	
	CustomerInformation customerInformation;
	
	@BeforeAll
	public void setup() {
		customerInformationRepository = mock(CustomerInformationRepository.class);
		customerInformationController.setCustomerInformationRepository(customerInformationRepository);

		//initial stub
		customerInformation = new CustomerInformation();
		customerInformation.setCustomerRef("CR6");
		customerInformation.setCustomerName("Gary Cox");
		customerInformation.setAddressLine1("100 St Mary St");
		customerInformation.setAddressLine2("");
		customerInformation.setTown("Weymouth");
		customerInformation.setCounty("Dorset");
		customerInformation.setCountry("United Kingdom");
		customerInformation.setPostCode("DT4 8NY");
		customerInformation.setCustomerId(99L);
	}
	
	@Test
	public void getCustomerInformationByCustomerRef(){
		
		List<CustomerInformation> customerInformations = new ArrayList<CustomerInformation>();
		customerInformations.add(customerInformation);
		
		when(customerInformationRepository.findByCustomerRef("CR1")).thenReturn(customerInformations);
		
		assertEquals(customerInformationController.getCustomerInformationByCustomerRef("CR1"), customerInformation);
		//verify customerInformationRepository executed
		verify(customerInformationRepository).findByCustomerRef("CR1");
	}

	@Test
	public void postCustomerInformation(){
		
		when(customerInformationRepository.nextCustomerId()).thenReturn(99L);
		when(customerInformationRepository.save(customerInformation)).thenReturn(customerInformation);
		assertEquals(99L, customerInformationController.postCustomerInformation(customerInformation).getCustomerId());
		//verify customerInformationRepository executed
		verify(customerInformationRepository).save(customerInformation); 
		
	}
}
