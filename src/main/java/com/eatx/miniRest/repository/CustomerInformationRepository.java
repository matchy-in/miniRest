package com.eatx.miniRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eatx.miniRest.model.CustomerInformation;

@Repository
public interface CustomerInformationRepository extends CrudRepository<CustomerInformation,Long> {

	/**
	 * retrieve the customer information
	 * @param customerRef
	 * @return the list of Customer Information
	 */
    List<CustomerInformation> findByCustomerRef(String customerRef);
    
    /**
     * saved customerInformation to a SQL database
     * @param customerInformation
     * @return the id of saved record
     */
    @SuppressWarnings("unchecked")
	CustomerInformation save(CustomerInformation customerInformation);
    
    /**
     * 
     * @return 
     */

	@Query(value = "SELECT nextval('customer_information_customer_id_seq')", nativeQuery = true)
    long nextCustomerId();
}
