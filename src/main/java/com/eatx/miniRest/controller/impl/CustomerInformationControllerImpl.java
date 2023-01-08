package com.eatx.miniRest.controller.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eatx.miniRest.MiniRestApplication;
import com.eatx.miniRest.controller.CustomerInformationController;
import com.eatx.miniRest.model.CustomerInformation;
import com.eatx.miniRest.repository.CustomerInformationRepository;

@RestController
public class CustomerInformationControllerImpl implements CustomerInformationController{

	Log logger = LogFactory.getLog(CustomerInformationControllerImpl.class);
	
	@Autowired
	CustomerInformationRepository customerInformationRepository;

	/**
	 * get Customer Information by customerRef
	 * @param customerRef
	 * @return Customer Information by JSON format
	 */
	@Override
	@GetMapping(value = "/customerInformation", produces = "application/json")
	public String getCustomerInformationByCustomerRef(String customerRef) {
		return null;
	}

	/**
	 * post Customer Information
	 * @param customerRef
	 * @return Customer Information id by JSON format
	 */
	@Override
	@PostMapping(value = "/customerInformation", consumes = "application/json", produces = "application/json")
	public String postCustomerInformation(CustomerInformation customerInformation) {
		logger.debug(customerInformation.toString());
		return null;
	}
}
