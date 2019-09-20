package com.jk.controller;

import com.jk.model.Highcharts;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.HbServiceApi;
import com.jk.service.XxfServiceApi;
import com.jk.util.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HbController {

    @Autowired
    private HbServiceApi hbServiceApi;

    @RequestMapping("/test")
    public Map test(){
        Map map=hbServiceApi.test();
        return map;
    }

    @RequestMapping("login")
    public User login(String username){
        return hbServiceApi.login(username);
    }

    @RequestMapping("getAllTree")
    public List<Tree> getTreeAll(Integer id){
       return  hbServiceApi.getTreeAll(id);
    }

    @RequestMapping("queryResume")
    public ResultPage queryResumeList(@RequestBody ResultPage result) {
        return hbServiceApi.queryResumeList(result);
    }

    @RequestMapping("deleteResume")
    public Boolean deleteResume(String ids){
        try {
            hbServiceApi.deleteResume(ids);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("queryAccount")
    public ResultPage queryAccount(@RequestBody ResultPage result){
        return hbServiceApi.queryAccountList(result);
    }


    @RequestMapping("deleteAccount")
    public Boolean deleteAccount(String ids){
        try {
            hbServiceApi.deleteAccount(ids);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("queryStay")
    public ResultPage queryStay(@RequestBody ResultPage result){
        return hbServiceApi.queryStayList(result);
    }

    @RequestMapping("deleteStay")
    public Boolean deleteStay(String ids){
        try {
            hbServiceApi.deleteStay(ids);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("updateResume1")
    public void updateResume1(Integer id){
        hbServiceApi.updateResume1(id);
    }

    @RequestMapping("updateResume2")
    public void updateResume2(Integer id){
        hbServiceApi.updateResume2(id);
    }

    @RequestMapping("queryCompany")
    public ResultPage queryCompany(@RequestBody ResultPage result){
        return hbServiceApi.queryCompanyList(result);}

    @RequestMapping("deleteCompany")
    public Boolean deleteCompany(String ids){
        try {
            hbServiceApi.deleteCompany(ids);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("queryDayCount")
    public List<Highcharts> queryDayCount(){
        List<Highcharts> list=hbServiceApi.queryDayCount();
        return list;
    }

    @RequestMapping("queryHighcharts")
    public Highcharts queryHighcharts(String time) {
        return hbServiceApi.queryHighcharts(time);
    }

    @RequestMapping("addHighcharts")
    public void addHighcharts(Highcharts highcharts) {
        hbServiceApi.addHighcharts(highcharts);
    }

    @RequestMapping("updateHighcharts")
    public void updateHighcharts(Integer id) {
        hbServiceApi.updateHighcharts(id);
    }
}
