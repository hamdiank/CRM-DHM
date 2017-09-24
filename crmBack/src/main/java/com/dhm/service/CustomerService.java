package com.dhm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dhm.entities.Customer;

public interface CustomerService {

	Customer getCustomerById(String id);

	Customer getCustomerByUserName(String userName);

	List<Customer> getAllCustomer();

	ResponseEntity<?> addCustomer(Customer customer);

	ResponseEntity<?> updateCustomer(Customer customer);

	ResponseEntity<?> deleteCustomer(String id);

	Boolean isCustomerExist(String Username);

}
