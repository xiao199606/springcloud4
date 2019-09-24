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

    @Override
    public ResultPage queryStayList(ResultPage result) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("result", result);

        //查询总条数
        Integer count = hbDao.queryStayCount(hashMap);
        resultPage.setTotal(count);

        hashMap.put("start", (result.getPageNumber()-1)*result.getPageSize());
        hashMap.put("end", result.getPageSize());

        //查询所有数据
        List<Zwjl> list = hbDao.HashMap3(hashMap);
        resultPage.setRows(list);
        return resultPage;
    }

    @Override
    public void deleteStay(String ids) {
        String[] arrIds= ids.split(",");
        hbDao.deleteStay(arrIds);
    }

    @Override
    public void updateResume1(Integer id) {
        hbDao.updateResume1(id);
    }

    @Override
    public void updateResume2(Integer id) {
        hbDao.updateResume2(id);
    }

    @Override
    public ResultPage queryCompanyList(ResultPage result) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("result", result);

        //查询总条数
        Integer count = hbDao.queryCompanyCount();
        resultPage.setTotal(count);

        hashMap.put("start", (result.getPageNumber()-1)*result.getPageSize());
        hashMap.put("end", result.getPageSize());

        //查询所有数据
        List<GsyhModel> list = hbDao.HashMap4(hashMap);
        resultPage.setRows(list);
        return resultPage;
    }

    @Override
    public void deleteCompany(String ids) {
        String[] arrIds= ids.split(",");
        hbDao.deleteCompany(arrIds);
    }

    @Override
    public List<Highcharts> queryDayCount() {
        return hbDao.queryDayCount();
    }

    @Override
    public Highcharts queryHighcharts(String time) {
        return hbDao.queryHighcharts(time);
    }

    @Override
    public void addHighcharts(Highcharts highcharts) {
        hbDao.addHighcharts(highcharts);
    }

    @Override
    public void updateHighcharts(Integer id) {
        hbDao.updateHighcharts(id);
    }

    @Override
    public ResultPage queryUserList(ResultPage result) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("result", result);

        //查询总条数
        Integer count = hbDao.queryUserCount();
        resultPage.setTotal(count);

        hashMap.put("start", (result.getPageNumber()-1)*result.getPageSize());
        hashMap.put("end", result.getPageSize());

        //查询所有数据
        List<User> list = hbDao.HashMap5(hashMap);
        resultPage.setRows(list);
        return resultPage;
    }

    @Override
    public void deleteUser(String ids) {
        String[] arrIds= ids.split(",");
        hbDao.deleteUser(arrIds);
    }

    @Override
    public ResultPage queryGuangList(ResultPage result) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("result", result);

        //查询总条数
        Integer count = hbDao.queryGuangCount();
        resultPage.setTotal(count);

        hashMap.put("start", (result.getPageNumber()-1)*result.getPageSize());
        hashMap.put("end", result.getPageSize());

        //查询所有数据
        List<Guanggao> list = hbDao.HashMap6(hashMap);
        resultPage.setRows(list);
        return resultPage;
    }

    @Override
    public String addGuang(Guanggao guanggao) {
        Integer count = hbDao.queryaddGuang();
        if (count>=3){
            return "1";
        }
        User user=hbDao.querygs(guanggao.getGsid());
        System.out.println(user.getGsyhid());
        String url="jump/toTheCompanyDetails?ids=gs.getId()";
        guanggao.setUrl(url);
        guanggao.setGsid(user.getGsyhid());
        hbDao.addGuang(guanggao);
        return "2";
    }

    @Override
    public List<LanWei> querylanwei() {
        return hbDao.querylanwei();
    }

    @Override
    public List<Tree> getTreeAll2(Integer ids) {
        return hbDao.getTreeAll2(ids);
    }
}
