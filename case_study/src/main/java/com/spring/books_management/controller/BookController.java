package com.spring.books_management.controller;

import com.spring.books_management.exception.exceptions.NoBookFoundException;
import com.spring.books_management.model.dto.SavingBookDTO;
import com.spring.books_management.model.entity.BookEntity;
import com.spring.books_management.model.dto.PartialBookInforMainDTO;
import com.spring.books_management.service.impl.BookService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PartialBookInforMainDTO> getAllBooks() {
        List<PartialBookInforMainDTO> books = bookService.getPartialBookInfor();
        return books;
    }

    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<BookEntity> getBooksDetail() {
        List<BookEntity> bookEntities = (List<BookEntity>) bookService.findAll();
        return bookEntities;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@Valid @RequestBody SavingBookDTO book) {
        System.out.println(book + "book");
        bookService.saveBookDTO(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable Long id, @RequestBody BookEntity bookEntity) {
        Optional<BookEntity> bookOptional = bookService.findById(id);
        if (bookOptional.isEmpty()) {
            throw new NoBookFoundException("Không tìm thấy sách có id" + " " + id);
        }
        bookService.save(bookEntity);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id) {
        Optional<BookEntity> bookOptional = bookService.findById(id);
        if (bookOptional.isEmpty()) {
            throw new NoBookFoundException("Không tìm thấy sách có id" + " " + id);
        }

        bookService.remove(id);
    }

}
