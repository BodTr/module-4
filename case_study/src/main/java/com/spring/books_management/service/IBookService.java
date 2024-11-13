package com.spring.books_management.service;

import com.spring.books_management.model.dto.SavingBookDTO;
import com.spring.books_management.model.entity.BookEntity;
import com.spring.books_management.model.dto.PartialBookInforMainDTO;

import java.util.List;

public interface IBookService extends IGenreralService<BookEntity> {
    public List<PartialBookInforMainDTO> getPartialBookInfor();
}
