package com.jk.service;
import com.jk.dao.ZcDao;
import com.jk.model.Book;
import com.jk.model.zcModel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZcServiceImpl implements ZcServiceApi {
    @Autowired
    private ZcDao zcDao;

    @Override
    public Map test() {
        List<Book> list=zcDao.test();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("rows",list);
        return map;
    }

    //注册
    @Override
    public void zcRegister(UserModel userModel) {
        zcDao.zcRegister(userModel);
    }
}
