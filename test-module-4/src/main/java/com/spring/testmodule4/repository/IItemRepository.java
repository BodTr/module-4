package com.spring.testmodule4.repository;

import com.spring.testmodule4.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<ItemEntity, Long> {
}
