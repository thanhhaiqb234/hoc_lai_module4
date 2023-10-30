package com.codegym.service;

import com.codegym.model.Books;

import java.util.List;

public interface IBookService {
    List<Books> getAllBook();

    Books finById(int id);
}
