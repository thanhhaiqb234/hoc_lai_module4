package com.codegym.repository;


import com.codegym.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;

public interface IBookRepository extends JpaRepository<Books, Integer> {
}
