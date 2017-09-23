package com.dhm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dhm.entities.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

}
