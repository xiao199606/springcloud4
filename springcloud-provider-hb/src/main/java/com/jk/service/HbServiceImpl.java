package com.jk.service;

import com.jk.dao.HbDao;
import com.jk.model.Book;
import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HbServiceImpl implements HbServiceApi {
    @Autowired
    private HbDao hbDao;

    @Override
    public Map test() {
        List<Book> list=hbDao.test();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("rows",list);
        return map;
    }

    @Override
    public User login(String username) {
        return hbDao.login(username);
    }

    @Override
    public List<Tree> getTreeAll() {
        return hbDao.getTreeAll();
    }
}
