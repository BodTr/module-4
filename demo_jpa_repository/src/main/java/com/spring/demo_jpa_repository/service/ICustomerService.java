package com.spring.demo_jpa_repository.service;

import com.spring.demo_jpa_repository.model.Customer;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer>{
    List<Customer> findTop3ByFirstName(String firstName);
}
