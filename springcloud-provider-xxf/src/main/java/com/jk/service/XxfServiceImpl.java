package com.jk.service;

import com.jk.dao.XxfDao;
import com.jk.model.Book;
import com.jk.model.Tree;
import com.jk.model.Zwjl;
import com.jk.util.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XxfServiceImpl implements XxfServiceApi {

    @Autowired XxfDao xxfDao;

    @Override
    public List<Tree> getTreeAll() {
        return xxfDao.getTreeAll();
    }

    @Override
    public ResultPage queryZwjl(ResultPage resultPage) {
        ResultPage Page = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("result", resultPage);

        //查询总条数
        Integer count = xxfDao.queryResumeCount();
        Page.setTotal(count);

        hashMap.put("start", (resultPage.getPageNumber()-1)*resultPage.getPageSize());
        hashMap.put("end", resultPage.getPageSize());

        //查询所有数据
        List<Zwjl> list = xxfDao.queryZwjl(hashMap);
        Page.setRows(list);
        return Page;
    }
}
