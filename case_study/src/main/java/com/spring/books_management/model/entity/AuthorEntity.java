package com.spring.books_management.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table(name = "authors")
@Data
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Trường name trống")
    private String name;

    @NotEmpty(message = "Trường birthDate trống")
    private LocalDate birthDate;

    @NotEmpty(message = "Trường bio trống")
    private String bio;
}
