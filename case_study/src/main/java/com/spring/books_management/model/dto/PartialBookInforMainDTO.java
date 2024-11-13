package com.spring.books_management.model.dto;

import lombok.Data;

@Data
public class PartialBookInforMainDTO {
    private Long id;
    private String title;
    private String authorName;
    private double price;
}
