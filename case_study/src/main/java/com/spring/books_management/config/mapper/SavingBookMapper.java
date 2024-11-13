package com.spring.books_management.config.mapper;

import com.spring.books_management.model.dto.SavingBookDTO;
import com.spring.books_management.model.entity.AuthorEntity;
import com.spring.books_management.model.entity.BookEntity;
import com.spring.books_management.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class SavingBookMapper {

    public BookEntity BookDTOToEntity(SavingBookDTO savingBookDTO, AuthorEntity authorEntity){

        String title = savingBookDTO.getTitle();
        String publisher = savingBookDTO.getPublisher();
        String isbn = savingBookDTO.getIsbn();
        String genre = savingBookDTO.getGenre();
        int pages_count = savingBookDTO.getPages_count();
        double price = savingBookDTO.getPrice();
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(title);
        bookEntity.setPublisher(publisher);
        bookEntity.setIsbn(isbn);
        bookEntity.setGenre(genre);
        bookEntity.setPages_count(pages_count);
        bookEntity.setPrice(price);
        bookEntity.setAuthorEntity(authorEntity);
        return bookEntity;
    }
}
