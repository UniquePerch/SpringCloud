package com.borrow.mapper;

import com.test.eneity.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("select * from t_borrow where uid = #{uid}")
    List<Borrow> getBorrowsByUid(int uid);

    @Select("select * from t_borrow where bid = #{bid}")
    List<Borrow> getBorrowsByBid(int bid);

    @Select("select * from t_borrow where bid = #{bid} and uid = #{uid}")
    Borrow getBorrow(int uid, int bid);

    @Insert("insert into t_borrow(uid,bid) values (#{uid},#{bid})")
    int addBorrow(int uid,int bid);
}
