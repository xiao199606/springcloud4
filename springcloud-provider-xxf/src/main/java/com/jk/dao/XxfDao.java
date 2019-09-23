package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.Leib;
import com.jk.model.Tree;
import com.jk.model.Zwjl;

import java.util.HashMap;
import java.util.List;

public interface XxfDao {

    List<Tree> getTreeAll();

    Integer queryResumeCount();

    List<Zwjl> queryZwjl(HashMap<String, Object> hashMap);

    List<Leib> queryleib();

    void addgsZwjl(Zwjl zwjl);

    void deleteResume(String[] arrIds);

    Zwjl findZwjlById(Integer id);

    void updateZwjl(Zwjl zwjl);
}
