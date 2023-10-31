package com.codegym.service;

import com.codegym.model.Books;
import com.codegym.model.Orders;

import java.util.List;

public interface IBookService {
    List<Books> getAllBook();

    Books finById(int id);

    void orderBook(Books books);

    void returnsBook(Books books);
}
