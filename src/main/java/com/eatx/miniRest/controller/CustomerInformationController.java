package com.eatx.miniRest.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.eatx.miniRest.model.CustomerInformation;

public interface CustomerInformationController {

	public String getCustomerInformationByCustomerRef(@RequestParam(value="customerRef", required=true) String customerRef);
	
	public String postCustomerInformation(@RequestBody CustomerInformation customerInformation);
}
