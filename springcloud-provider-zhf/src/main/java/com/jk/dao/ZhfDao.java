package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.Gryh;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZhfDao {
    List<Book> test();

    Gryh querygy(Integer id);

    void toujl(@Param("gsid") Integer gsid,@Param("jlid") Integer jlid);
}
