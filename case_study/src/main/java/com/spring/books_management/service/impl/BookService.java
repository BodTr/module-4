package com.spring.books_management.service.impl;

import com.spring.books_management.config.mapper.GetPartialBookInforMapper;
import com.spring.books_management.config.mapper.SavingBookMapper;
import com.spring.books_management.model.dto.SavingBookDTO;
import com.spring.books_management.model.entity.AuthorEntity;
import com.spring.books_management.model.entity.BookEntity;
import com.spring.books_management.model.dto.PartialBookInforMainDTO;
import com.spring.books_management.repository.IBookRepository;
import com.spring.books_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService  implements IBookService {
    private final IBookRepository bookRepository;

    private final AuthorService authorService;

    private final GetPartialBookInforMapper getPartialBookInforMapper;

    private final SavingBookMapper savingBookMapper;

    @Autowired
    public BookService(IBookRepository bookRepository, AuthorService authorService, GetPartialBookInforMapper getPartialBookInforMapper, SavingBookMapper savingBookMapper) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.getPartialBookInforMapper = getPartialBookInforMapper;
        this.savingBookMapper = savingBookMapper;
    }

    @Override
    public Iterable<BookEntity> findAll() {

        return bookRepository.findAll();
    }

    @Override
    public List<PartialBookInforMainDTO> getPartialBookInfor() {
        List<BookEntity> rawBooksList = bookRepository.findAll();

        return rawBooksList.stream().map(getPartialBookInforMapper::mapPartialBookDTO).collect(Collectors.toList());
    }

    @Override
    public void save(BookEntity book) {
        bookRepository.save(book);
    }

    public void saveBookDTO(SavingBookDTO book) {
        Long author_id = book.getAuthor_id();
        Optional<AuthorEntity> author = authorService.findById(author_id);
        if (author.isPresent()) {
            AuthorEntity authorEntity = author.get();
            BookEntity bookEntity = savingBookMapper.BookDTOToEntity(book, authorEntity);
            this.save(bookEntity);
        } else {
            throw new NullPointerException("Author not found");
        }

    }


    @Override
    public Optional<BookEntity> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }
}
