package com.jk.service;

import com.jk.dao.XxfDao;
import com.jk.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XxfServiceImpl implements XxfServiceApi {
    @Autowired
    private XxfDao xxfDao;

    @Override
    public Map test() {
        List<Book> list=xxfDao.test();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("rows",list);
        return map;
    }
}
