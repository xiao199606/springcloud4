package com.jk.dao;

import com.jk.model.*;

import java.util.HashMap;
import java.util.List;

public interface HbDao {
    List<Book> test();

    User login(String username);

    List<Tree> getTreeAll(Integer id);

    Integer queryResumeCount(HashMap<String, Object> hashMap);

    List<JianLi> HashMap(HashMap<String, Object> hashMap);

    void deleteResume(String[] arrIds);

    Integer queryAccountCount(HashMap<String, Object> hashMap);

    List<Gryh> HashMap2(HashMap<String, Object> hashMap);

    void deleteAccount(String[] arrIds);

    Integer queryStayCount(HashMap<String, Object> hashMap);

    List<Zwjl> HashMap3(HashMap<String, Object> hashMap);
}
