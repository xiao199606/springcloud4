package com.jk.controller;

import com.jk.model.*;
import com.jk.service.HbService;
import com.jk.service.HbServiceApi;
import com.jk.service.XxfService;
import com.jk.util.OSSClientUtil;
import com.jk.util.ResultPage;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.font.EAttribute;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("Hb")
public class HbController {

    @Autowired
    private HbService hbService;

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

    @RequestMapping("getAllTree2")
    @ResponseBody
    public List<Tree> getTreeAll2(HttpServletRequest request) {
        Integer ids = (Integer) request.getSession().getAttribute("ids2");
        List<Tree> list = new ArrayList();
        list = hbService.getTreeAll2(ids);
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

    @RequestMapping("queryUser")
    @ResponseBody
    public ResultPage queryUser(@RequestBody ResultPage result) {
        ResultPage resultPage = hbService.queryUserList(result);
        return resultPage;
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public Boolean deleteUser(String ids) {
        try {
            hbService.deleteUser(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("queryGuang")
    @ResponseBody
    public ResultPage queryGuang(@RequestBody ResultPage result) {
        ResultPage resultPage = hbService.queryGuangList(result);
        return resultPage;
    }

    //阿里云上传图片
    @RequestMapping("updaloadImg")
    @ResponseBody
    public String uploadImg(MultipartFile img)throws IOException {
        System.out.println(img+"=============");
        if (img == null || img.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(img);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        //System.out.println(split[0]);
        return split[0];
    }

    @RequestMapping("addGuang")
    @ResponseBody
    public String addGuang(Guanggao guanggao, HttpServletRequest request){
        Integer ids2 = (Integer) request.getSession().getAttribute("ids2");
        guanggao.setGsid(ids2);
        return hbService.addGuang(guanggao);
    }



    @RequestMapping("querylanwei")
    @ResponseBody
    public List<LanWei> querylanwei() {
        return hbService.querylanwei();
    }

    @RequestMapping("queryimg1")
    @ResponseBody
    public String queryimg1(){
       return hbService.queryimg1();
    }

    @RequestMapping("queryimg2")
    @ResponseBody
    public String queryimg2(){
        return hbService.queryimg2();
    }

    @RequestMapping("queryimg3")
    @ResponseBody
    public String queryimg3(){
        return hbService.queryimg3();
    }
}
