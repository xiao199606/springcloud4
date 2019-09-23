package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.JianLi;

import java.util.List;

public interface LmhDao {

    void updateJianLi();

    List<JianLi> queryJianL(Integer ids1);
}
