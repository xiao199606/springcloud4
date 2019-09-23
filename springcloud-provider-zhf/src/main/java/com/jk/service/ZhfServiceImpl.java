package com.jk.service;

import com.jk.dao.ZhfDao;
import com.jk.model.Gryh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZhfServiceImpl implements ZhfService2 {

    @Autowired
    private ZhfDao zhfDao;

    @Override
    public Gryh querygy(Integer id) {
        return zhfDao.querygy(id);
    }

    @Override
    public void toujl(Integer gsid, Integer jlid) {
        zhfDao.toujl(gsid,jlid);
    }
}
