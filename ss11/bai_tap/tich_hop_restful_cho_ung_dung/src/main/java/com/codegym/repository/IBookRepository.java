package com.codegym.repository;

import com.codegym.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Books , Integer> {
}
