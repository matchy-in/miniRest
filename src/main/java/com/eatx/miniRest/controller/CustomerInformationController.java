package com.eatx.miniRest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.eatx.miniRest.model.CustomerInformation;
import com.eatx.miniRest.repository.CustomerInformationRepository;

public interface CustomerInformationController {

	/**
	 * get Customer Information by customerRef
	 * @param customerRef
	 * @return Customer Information by JSON format
	 */
	public CustomerInformation getCustomerInformationByCustomerRef(@RequestParam(value="customerRef", required=true) String customerRef);


	/**
	 * post Customer Information
	 * @param customerRef
	 * @return Customer Information id by JSON format
	 */
	public CustomerInformation postCustomerInformation(@RequestBody CustomerInformation customerInformation);
	
	/**
	 * delete Customer Information
	 * @param customerId
	 * @return successful message in JSON format, eg, {"success":true}
	 */
	public String deleteCustomerInformation(@RequestParam(value="customerId", required=true) long customerId);


	public void setCustomerInformationRepository(CustomerInformationRepository customerInformationRepository);


	public CustomerInformationRepository getCustomerInformationRepository();
}
