package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.zcModel.UserModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZcDao {
    List<Book> test();

    //注册
    void zcRegister(UserModel userModel);

    //查询用户
    @Select("select *  from  gryh WHERE tel = #{value}")
    UserModel queryTel(String tel);
}
