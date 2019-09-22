package com.jk.service;

import com.jk.model.*;
import com.jk.util.ResultPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface HbServiceApi {

    @GetMapping(value="test")
     Map test();

    @GetMapping(value="login")
    User login(@RequestParam("username") String username);

    @RequestMapping("getAllTree")
    List<Tree> getTreeAll(@RequestParam("id") Integer id);

    @RequestMapping("queryResume")
    ResultPage queryResumeList(@RequestBody ResultPage result);

    @RequestMapping("deleteResume")
    void deleteResume(@RequestParam("ids") String ids);

    @RequestMapping("queryAccount")
    ResultPage queryAccountList(@RequestBody ResultPage result);

    @RequestMapping("deleteAccount")
    void deleteAccount(@RequestParam("ids") String ids);

    @RequestMapping("queryStay")
    ResultPage queryStayList(@RequestBody ResultPage result);

    @RequestMapping("deleteStay")
    void deleteStay(@RequestParam("ids") String ids);

    @RequestMapping("updateResume1")
    void updateResume1(@RequestParam("id") Integer id);

    @RequestMapping("updateResume2")
    void updateResume2(@RequestParam("id") Integer id);

    @RequestMapping("queryCompany")
    ResultPage queryCompanyList(@RequestBody ResultPage result);

    @RequestMapping("deleteCompany")
    void deleteCompany(@RequestParam("ids") String ids);

    @RequestMapping("queryDayCount")
    List<Highcharts> queryDayCount();

    @RequestMapping("queryHighcharts")
    Highcharts queryHighcharts(@RequestParam("time") String time);

    @RequestMapping("addHighcharts")
    void addHighcharts(@RequestBody Highcharts highcharts);

    @RequestMapping("updateHighcharts")
    void updateHighcharts(@RequestParam("id") Integer id);

    @RequestMapping("queryUser")
    ResultPage queryUserList(@RequestBody ResultPage result);

    @RequestMapping("deleteUser")
    void deleteUser(@RequestParam("id") String ids);

    @RequestMapping("queryGuang")
    ResultPage queryGuangList(@RequestBody ResultPage result);

    @RequestMapping("addGuang")
    String addGuang(@RequestBody Guanggao guanggao);
    @RequestMapping("querylanwei")
    List<LanWei> querylanwei();
}
