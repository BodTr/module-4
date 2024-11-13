package com.spring.books_management.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    private String publisher;


    private String isbn;

    private String genre;

    private int pages_count;

    private double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;
}
