package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.Gryh;
import com.jk.model.JianLi;

import java.util.List;

public interface LmhDao {

    void updateJianLi(Integer id);

    List<JianLi> queryJianL(Integer ids1);

    Gryh queryjian(Integer id);
}
