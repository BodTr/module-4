package com.spring.demo_spring_boot_1.repository;

import com.spring.demo_spring_boot_1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
