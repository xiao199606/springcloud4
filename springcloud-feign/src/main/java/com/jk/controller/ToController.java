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

    //跳转到招聘官网首页
    @RequestMapping("toBosShow")
    public String toBosShow(){
        return "BOSS";
    }

    //查看更多职位
    @RequestMapping("toBoss2")
    public String boss2(){
        return "boss2";
    }

    //查看跟多公司
    @RequestMapping("toMoreCompanies")
    public String toMoreCompanies(){
        return  "boss3";
    }

    //跳转到个人登录注册
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    //跳转到Hr
    @RequestMapping("toHr")
    public String toHr(){

        return "hrfile";
    }


    @RequestMapping("tologin")
    public String tologin(){
        return "index";
    }

    @RequestMapping("tohbtree")
    public String tohbtree(){
        return "tree";
    }
}