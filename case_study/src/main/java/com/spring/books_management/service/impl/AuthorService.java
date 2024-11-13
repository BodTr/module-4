package com.spring.books_management.service.impl;

import com.spring.books_management.model.entity.AuthorEntity;
import com.spring.books_management.repository.IAuthorRepository;
import com.spring.books_management.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public Iterable<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void save(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }

    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        authorRepository.deleteById(id);
    }
}
