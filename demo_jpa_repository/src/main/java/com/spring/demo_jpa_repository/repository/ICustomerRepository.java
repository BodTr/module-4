package com.spring.demo_jpa_repository.repository;

import com.spring.demo_jpa_repository.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    @Query("select c from Customer c where c.firstName = ?1")
    List<Customer> findTop3ByFirstName(String firstName);

}
