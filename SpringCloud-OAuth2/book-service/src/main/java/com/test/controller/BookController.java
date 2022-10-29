package com.test.controller;

import com.test.entity.Book;
import com.test.service.BookService;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class BookController {

    @Resource
    BookService service;

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid, HttpSession session){
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication());
        return service.getBookById(bid);
    }
}