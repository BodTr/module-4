package com.spring.testmodule4.service.impl;

import com.spring.testmodule4.model.OrderEntity;
import com.spring.testmodule4.repository.IOrderRepository;
import com.spring.testmodule4.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Iterable<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(OrderEntity order) {
        orderRepository.save(order);
    }

    @Override
    public Optional<OrderEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {
        orderRepository.deleteById(id);
    }


}
