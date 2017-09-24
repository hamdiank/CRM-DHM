package com.dhm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dhm.entities.Customer;
import com.dhm.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer getCustomerById(String id) {
		return customerRepository.findOne(id);
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		return customerRepository.findByUserName(userName);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public ResponseEntity<?> addCustomer(Customer customer) {
		if (!isCustomerExist(customer.getUserName())) {
			logger.error("unable to create customer : " + customer.getUserName() + " already exist ! ");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		customerRepository.save(customer);
		return new ResponseEntity<>("customer saved with success", HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<?> updateCustomer(Customer customer) {
		customerRepository.save(customer);
		return new ResponseEntity<>("customer updated with success", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteCustomer(String id) {
		if (customerRepository.findOne(id) == null) {
			logger.error("unable to delete customer : not found ! ");
			return new ResponseEntity<>("customer not found", HttpStatus.NOT_FOUND);
		}
		customerRepository.delete(id);
		return new ResponseEntity<>("customer deleted with success", HttpStatus.OK);
	}

	@Override
	public Boolean isCustomerExist(String userName) {
		return this.customerRepository.findByUserName(userName) != null;
	}

}
