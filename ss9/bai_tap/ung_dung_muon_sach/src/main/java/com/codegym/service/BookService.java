package com.codegym.service;

import com.codegym.model.Books;
import com.codegym.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{


    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Books> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Books finById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void orderBook(Books books) {
        bookRepository.save(books);
    }

    @Override
    public void returnsBook(Books books) {
        bookRepository.save(books);
    }

}
