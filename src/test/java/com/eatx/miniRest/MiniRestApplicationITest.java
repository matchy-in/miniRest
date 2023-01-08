package com.eatx.miniRest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eatx.miniRest.controller.CustomerInformationController;
import com.eatx.miniRest.model.CustomerInformation;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class MiniRestApplicationITest {

	@Autowired
	CustomerInformationController customerInformationController;
	
	@Test
	void testUserStory2_getNonExistingCustomerInformation() {
		String customerRef = "CR0";
		
		CustomerInformation customerInformation = customerInformationController.getCustomerInformationByCustomerRef(customerRef);
		
		assertNull(customerInformation);
	}
}
