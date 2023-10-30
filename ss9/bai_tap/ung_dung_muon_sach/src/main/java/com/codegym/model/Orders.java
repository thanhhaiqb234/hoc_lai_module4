package com.codegym.model;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "books_id" , referencedColumnName = "id")
    private Books books;
    private String borrowcCode;

    public Orders() {
    }

    public Orders(int id, Books books, String borrowcCode) {
        this.id = id;
        this.books = books;
        this.borrowcCode = borrowcCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public String getBorrowcCode() {
        return borrowcCode;
    }

    public void setBorrowcCode(String borrowcCode) {
        this.borrowcCode = borrowcCode;
    }
}
