package com.spring.testmodule4.controller;


import com.spring.testmodule4.exception.exceptions.NoOrderFoundException;
import com.spring.testmodule4.model.OrderEntity;
import com.spring.testmodule4.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<OrderEntity> getOrders() {
        return orderService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderEntity order) {
        orderService.save(order);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@PathVariable Long id, @RequestBody OrderEntity order) {
        Optional<OrderEntity> orderEntity = orderService.findById(id);
        if (orderEntity.isPresent()) {
            throw new NoOrderFoundException("Không tìm thấy order");
        }
        orderService.save(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable Long id) {
        Optional<OrderEntity> orderEntity = orderService.findById(id);
        if (orderEntity.isPresent()) {
            throw new NoOrderFoundException("Không tìm thấy order");
        }
        orderService.remove(id);
    }
}
