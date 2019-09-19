package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jump")
public class ToController {
    //测试框架
    @RequestMapping("toBookList")
    public String toBookList(){
        return "bookList";
    }

    //登录页面
    @RequestMapping("tologin")
    public String tologin(){
        return "index";
    }

    //后台树页面
    @RequestMapping("tohbtree")
    public String tohbtree(){
        return "tree";
    }

    //简历查询页面
    @RequestMapping("queryResume")
    public String queryResume(){
        return "queryResume";
    }

    //简历新增页面
    @RequestMapping("toAddResume")
    public String addResume(){
        return "addResume";
    }

    //个人账号查询页面
    @RequestMapping("queryAccount")
    public String queryAccount(){
        return "queryAccount";
    }

    //个人账号查询页面
    @RequestMapping("queryStay")
    public String queryStay(){
        return "queryStay";
    }
}
