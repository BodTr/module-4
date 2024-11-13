package com.spring.testmodule4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "itemTypes")
@Data
public class ItemTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


}
