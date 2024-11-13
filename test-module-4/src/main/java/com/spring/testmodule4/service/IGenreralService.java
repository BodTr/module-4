package com.spring.testmodule4.service;

import java.util.Optional;

public interface IGenreralService<T> {
    Iterable<T> findAll();
    void save(T t);
    Optional<T> findById(Long id);
    void remove(Long id);
}