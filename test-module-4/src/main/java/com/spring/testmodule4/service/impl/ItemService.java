package com.spring.testmodule4.service.impl;

import com.spring.testmodule4.model.ItemEntity;
import com.spring.testmodule4.repository.IItemRepository;
import com.spring.testmodule4.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService implements IItemService {
    @Autowired
    private IItemRepository itemRepository;

    @Override
    public Iterable<ItemEntity> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public void save(ItemEntity itemEntity) {
        itemRepository.save(itemEntity);
    }

    @Override
    public Optional<ItemEntity> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        itemRepository.deleteById(id);
    }
}
