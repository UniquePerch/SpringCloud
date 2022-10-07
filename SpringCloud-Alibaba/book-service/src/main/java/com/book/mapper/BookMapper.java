package com.book.mapper;

import com.test.eneity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookMapper {

    @Select("select * from t_book where bid = #{bid}")
    Book getBookById(int bid);

    @Select("select count from t_book  where bid = #{bid}")
    int getRemain(int bid);

    @Update("update t_book set count = #{count}  where bid = #{bid}")
    int setRemain(int bid, int count);
}