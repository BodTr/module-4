package com.spring.books_management.repository;


import com.spring.books_management.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBookRepository  extends JpaRepository<BookEntity, Long> {
}
