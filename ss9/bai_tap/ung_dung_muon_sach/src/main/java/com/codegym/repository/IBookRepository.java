package com.codegym.repository;



import com.codegym.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface IBookRepository extends JpaRepository<Books,Integer> {
}
