package com.spring.testmodule4.controller;

import com.spring.testmodule4.model.ItemEntity;
import com.spring.testmodule4.service.impl.ItemService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<ItemEntity> getItems() {
        return itemService.findAll();
    }
}
