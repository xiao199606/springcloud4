package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.zcModel.UserModel;

import java.util.List;

public interface ZcDao {
    List<Book> test();

    //注册
    void zcRegister(UserModel userModel);
}
