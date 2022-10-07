package com.user.mapper;

import com.test.eneity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from t_user where uid = #{uid}")
    User getUserById(int uid);

    @Select("select book_count from t_user where uid = #{uid}")
    int getUserBookRemain(int uid);

    @Update("update t_user set book_count = #{count} where uid = #{uid}")
    int updateBookCount(int uid, int count);
}
