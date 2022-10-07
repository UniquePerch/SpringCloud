package com.book.mapper;

import com.test.eneity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {

    @Select("select * from t_book where bid = #{bid}")
    Book getBookById(int bid);
}