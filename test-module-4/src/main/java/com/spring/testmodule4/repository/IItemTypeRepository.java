package com.spring.testmodule4.repository;

import com.spring.testmodule4.model.ItemTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemTypeRepository  extends JpaRepository<ItemTypeEntity, Long> {
}
