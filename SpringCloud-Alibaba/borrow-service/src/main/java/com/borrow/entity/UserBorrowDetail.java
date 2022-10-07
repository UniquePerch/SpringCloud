package com.borrow.entity;

import com.test.eneity.Book;
import com.test.eneity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class UserBorrowDetail {
    User user;
    List<Book> bookList;
}