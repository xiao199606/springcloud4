package com.jk.controller;

import com.jk.model.Highcharts;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.HbService;
import com.jk.service.HbServiceApi;
import com.jk.service.XxfService;
import com.jk.util.ResultPage;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.font.EAttribute;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Hb")
public class HbController {

    @Autowired
    private HbService hbService;

    @RequestMapping("test")
    @ResponseBody
    public Map test() {

        return hbService.test();
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(User user, HttpServletRequest request) {
        User user1 = hbService.login(user.getUsername());
        if (user1 == null) {
            return "1";
        }
        if (!user1.getPassword().equals(user.getPassword())) {
            return "2";
        }
        request.getSession().setAttribute("user", user1);
        return "0";
    }

    @RequestMapping("getAllTree")
    @ResponseBody
    public List<Tree> getTreeAll(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Tree> list = new ArrayList();
        list = hbService.getTreeAll(user.getId());
        list = TreeNoteUtil.getFatherNode(list);
        return list;
    }

    @RequestMapping("queryResume")
    @ResponseBody
    public ResultPage queryResumeList(@RequestBody ResultPage result) {
        ResultPage resultPage = hbService.queryResumeList(result);
        return resultPage;
    }


    @RequestMapping("deleteResume")
    @ResponseBody
    public Boolean deleteResume(String ids) {
        try {
            hbService.deleteResume(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("queryAccount")
    @ResponseBody
    public ResultPage queryAccount(@RequestBody ResultPage result) {
        ResultPage resultPage = hbService.queryAccountList(result);
        return resultPage;
    }


    @RequestMapping("deleteAccount")
    @ResponseBody
    public Boolean deleteAccount(String ids) {
        try {
            hbService.deleteAccount(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("queryStay")
    @ResponseBody
    public ResultPage queryStay(@RequestBody ResultPage result) {
        ResultPage resultPage = hbService.queryStayList(result);
        return resultPage;
    }

    @RequestMapping("deleteStay")
    @ResponseBody
    public Boolean deleteStay(String ids) {
        try {
            hbService.deleteStay(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("updateResume1")
    @ResponseBody
    public void updateResume1(Integer id) {
        hbService.updateResume1(id);
    }

    @RequestMapping("updateResume2")
    @ResponseBody
    public void updateResume2(Integer id) {
        hbService.updateResume2(id);
    }

    @RequestMapping("queryCompany")
    @ResponseBody
    public ResultPage queryCompany(@RequestBody ResultPage result) {
        ResultPage resultPage = hbService.queryCompanyList(result);
        return resultPage;
    }

    @RequestMapping("deleteCompany")
    @ResponseBody
    public Boolean deleteCompany(String ids) {
        try {
            hbService.deleteCompany(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("queryDayCount")
    @ResponseBody
    public List<Highcharts> queryDayCount(){
        List<Highcharts> list=hbService.queryDayCount();
        return list;
    }
}
