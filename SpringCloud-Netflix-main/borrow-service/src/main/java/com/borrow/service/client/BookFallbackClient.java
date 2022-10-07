package com.borrow.service.client;

import com.test.eneity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookFallbackClient implements BookClient{

    @Override
    public Book findBookById(int bid) {
        return new Book();
    }
}
