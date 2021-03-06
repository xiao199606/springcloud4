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

    void deleteStay(String[] arrIds);
    

    void updateResume2(Integer id);

    Integer queryCompanyCount();

    List<GsyhModel> HashMap4(HashMap<String, Object> hashMap);

    void deleteCompany(String[] arrIds);

    List<Highcharts> queryDayCount();

    Highcharts queryHighcharts(String time);

    void addHighcharts(Highcharts highcharts);

    void updateHighcharts(Integer id);

    Integer queryUserCount();

    List<User> HashMap5(HashMap<String, Object> hashMap);

    void deleteUser(String[] arrIds);

    Integer queryGuangCount();

    List<Guanggao> HashMap6(HashMap<String, Object> hashMap);

    void addGuang(Guanggao guanggao);

    Integer queryaddGuang();

    List<LanWei> querylanwei();

    User querygs(Integer gsid);

    List<Tree> getTreeAll2(Integer ids);

    Gryh queryjianli(Integer id);

    void updateResume1(Integer jianLiId);

    String queryimg1();

    String queryimg2();

    String queryimg3();
}
