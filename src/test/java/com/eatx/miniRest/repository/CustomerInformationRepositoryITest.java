package com.eatx.miniRest.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eatx.miniRest.model.CustomerInformation;


/**
 * integration test of CustomerInformationRepository
 * @author match
 * @since 1.0
 */
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerInformationRepositoryITest {

	@Autowired
	CustomerInformationRepository customerInformationRepository;

	CustomerInformation customerInformation;
	
	@BeforeAll
	public void setup() {
		customerInformation = new CustomerInformation();
		
		customerInformation.setCustomerId(1L);
		customerInformation.setCustomerRef("CR0");
		customerInformation.setCustomerName("Gary Cox");
		customerInformation.setAddressLine1("100 St Mary St");
		customerInformation.setAddressLine2("");
		customerInformation.setTown("Weymouth");
		customerInformation.setCounty("Dorset");
		customerInformation.setCountry("United Kingdom");
		customerInformation.setPostCode("DT4 8NY");

		customerInformationRepository.save(customerInformation);
	}
	
	@Test
	public void testFindByCustomerRef() {
		List<CustomerInformation> customerInformations = customerInformationRepository.findByCustomerRef("CR0");
		assertEquals(1, customerInformations.get(0).getCustomerId());
	}
	
	@AfterAll
	public void deleteTestRecord() {
		customerInformationRepository.deleteById(1L);
	}
}
