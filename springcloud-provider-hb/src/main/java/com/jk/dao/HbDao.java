package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.Tree;
import com.jk.model.User;

import java.util.List;

public interface HbDao {
    List<Book> test();

    User login(String username);

    List<Tree> getTreeAll();
}
