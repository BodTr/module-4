package com.spring.demo_jpa_repository.repository;

import com.spring.demo_jpa_repository.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface IProvinceRepository extends CrudRepository<Province, Long> {

}
