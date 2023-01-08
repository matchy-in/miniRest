package com.eatx.miniRest.controller.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eatx.miniRest.controller.CustomerInformationController;
import com.eatx.miniRest.model.CustomerInformation;
import com.eatx.miniRest.repository.CustomerInformationRepository;

@RestController
public class CustomerInformationControllerImpl implements CustomerInformationController{

	Log logger = LogFactory.getLog(CustomerInformationControllerImpl.class);
	
	@Autowired
	CustomerInformationRepository customerInformationRepository;

	@Override
	public CustomerInformationRepository getCustomerInformationRepository() {
		return customerInformationRepository;
	}

	@Override
	public void setCustomerInformationRepository(CustomerInformationRepository customerInformationRepository) {
		this.customerInformationRepository = customerInformationRepository;
	}

	@Override
	@GetMapping(value = "/customerInformation", produces = "application/json")
	public CustomerInformation getCustomerInformationByCustomerRef(@RequestParam(value="customerRef", required=true) String customerRef) {
		List<CustomerInformation> customerInformations = customerInformationRepository.findByCustomerRef(customerRef);
		return customerInformations.isEmpty()?null:customerInformations.get(0);
	}
	
	@Override
	@PostMapping(value = "/customerInformation", consumes = "application/json", produces = "application/json")
	public CustomerInformation postCustomerInformation(CustomerInformation customerInformation) {
		logger.debug(customerInformation.toString());
		
		long customerId = customerInformationRepository.nextCustomerId();
		customerInformation.setCustomerId(customerId);
		
		customerInformationRepository.save(customerInformation);
		return customerInformation;
	}
	
	@Override
	@DeleteMapping(value = "/customerInformation", produces = "application/json")
	public String deleteCustomerInformation(long customerId) {
		customerInformationRepository.deleteById(customerId);
		
		return "{\"success\":true}";
	}
}
