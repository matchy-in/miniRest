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
		List<CustomerInformation> customerInformations = customerInformationRepository.findByCustomerRef("CR1");
		assertEquals(1, customerInformations.get(0).getCustomerId());
	}
	
	@Test
	public void save() {
		
	}
	
	@AfterAll
	public void deleteTestRecord() {
	}
}
