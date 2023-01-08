package com.eatx.miniRest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.eatx.miniRest.model.CustomerInformation;

public interface CustomerInformationController {

	public CustomerInformation getCustomerInformationByCustomerRef(@RequestParam(value="customerRef", required=true) String customerRef);
	
	public CustomerInformation postCustomerInformation(@RequestBody CustomerInformation customerInformation);
	
	public String deleteCustomerInformation(@RequestParam(value="customerId", required=true) long customerId);
}
