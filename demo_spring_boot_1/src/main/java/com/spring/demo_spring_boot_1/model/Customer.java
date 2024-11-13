package com.spring.demo_spring_boot_1.model;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name= "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "thiếu first name")
    @Min(value = 8, message = "first name tối thiểu có 8 ký tự")
    private String firstName;

    @NotEmpty(message = "thiếu last name")
    private String lastName;
}
