package com.book.service;


import com.test.eneity.Book;

public interface BookService {
    Book getBookById(int bid);

    boolean setRemain(int bid, int count);

    int getRemain(int bid);
}
