package com.book.service.Impl;


import com.book.mapper.BookMapper;
import com.book.service.BookService;
import com.test.eneity.Book;
import io.seata.core.context.RootContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper mapper;

    @Override
    public Book getBookById(int bid) {
        System.out.println("Hello world");
        return mapper.getBookById(bid);
    }
    @Override
    public boolean setRemain(int bid, int count) {
        return mapper.setRemain(bid, count) > 0;
    }

    @Override
    public int getRemain(int bid) {
        System.out.println(RootContext.getXID());
        return mapper.getRemain(bid);
    }
}
