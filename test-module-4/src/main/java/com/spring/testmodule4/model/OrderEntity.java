package com.spring.testmodule4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    private int itemCount;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;

//    public ItemTypeEntity getItemEntity() {
//        return itemEntity.getItemType();
//    }
}
