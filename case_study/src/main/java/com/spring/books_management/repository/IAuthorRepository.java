package com.spring.books_management.repository;

import com.spring.books_management.model.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAuthorRepository extends JpaRepository<AuthorEntity, Long> {

}
