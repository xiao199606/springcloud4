package com.jk.service;

import com.jk.dao.HbDao;
import com.jk.model.*;
import com.jk.util.ResultPage;
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
    public List<Tree> getTreeAll(Integer id) {
        return hbDao.getTreeAll(id);
    }

    @Override
    public ResultPage queryResumeList(ResultPage result) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("result", result);

        //查询总条数
        Integer count = hbDao.queryResumeCount(hashMap);
        resultPage.setTotal(count);

        hashMap.put("start", (result.getPageNumber()-1)*result.getPageSize());
        hashMap.put("end", result.getPageSize());

        //查询所有数据
        List<JianLi> list = hbDao.HashMap(hashMap);
        resultPage.setRows(list);
        return resultPage;
    }

    @Override
    public void deleteResume(String ids) {
        String[] arrIds= ids.split(",");
          hbDao.deleteResume(arrIds);
    }

    @Override
    public ResultPage queryAccountList(ResultPage result) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("result", result);

        //查询总条数
        Integer count = hbDao.queryAccountCount(hashMap);
        resultPage.setTotal(count);

        hashMap.put("start", (result.getPageNumber()-1)*result.getPageSize());
        hashMap.put("end", result.getPageSize());

        //查询所有数据
        List<Gryh> list = hbDao.HashMap2(hashMap);
        resultPage.setRows(list);
        return resultPage;
    }

    @Override
    public void deleteAccount(String ids) {
        String[] arrIds= ids.split(",");
        hbDao.deleteAccount(arrIds);
    }
}
