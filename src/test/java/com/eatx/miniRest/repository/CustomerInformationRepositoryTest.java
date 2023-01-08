package com.eatx.miniRest.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

import com.eatx.miniRest.model.CustomerInformation;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerInformationRepositoryTest {
	
	CustomerInformationRepository customerInformationRepository;
	
	CustomerInformation customerInformation;
	
	@BeforeAll
	public void setup() {
		customerInformationRepository = mock(CustomerInformationRepository.class);
		
		customerInformation = new CustomerInformation();
		customerInformation.setCustomerRef("CR6");
		customerInformation.setCustomerName("Gary Cox");
		customerInformation.setAddressLine1("100 St Mary St");
		customerInformation.setAddressLine2("");
		customerInformation.setTown("Weymouth");
		customerInformation.setCounty("Dorset");
		customerInformation.setCountry("United Kingdom");
		customerInformation.setPostCode("DT4 8NY");
	}
	
	@Test
	public void findByCustomerRef() {
		List<CustomerInformation> customerInformations = new ArrayList<CustomerInformation>();

		customerInformations.add(customerInformation);
		
		when(customerInformationRepository.findByCustomerRef("CR1")).thenReturn(customerInformations);
		assertEquals(1, customerInformationRepository.findByCustomerRef("CR1").size());
	}
	
	@Test
	public void save() {
		customerInformation.setCustomerId(6L);
		when(customerInformationRepository.save(customerInformation)).thenReturn(customerInformation);
		assertEquals(6L, customerInformationRepository.save(customerInformation).getCustomerId());
		
	}
}
