package com.eatx.miniRest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Entity
public class CustomerInformation {

	// "customer_information_customer_id_seq" is Oracle sequence name.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id")
    @SequenceGenerator(sequenceName = "customer_information_customer_id_seq", allocationSize = 1, name = "customer_id")
    @Getter @Setter Long customerId;

    @Column(name = "customer_ref")
    @Getter @Setter String customerRef;

    @Column(name = "customer_name")
    @Getter @Setter String customerName;

    @Column(name = "address_line_1")
    @Getter @Setter String addressLine1;

    @Column(name = "address_line_2")
    @Getter @Setter String addressLine2;

    @Column(name = "town")
    @Getter @Setter String town;

    @Column(name = "county")
    @Getter @Setter String county;

    @Column(name = "country")
    @Getter @Setter String country;

    @Column(name = "postcode")
    @Getter @Setter String postCode;
}
