package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //跳转到企业版登录注册
    @RequestMapping("toHrRegister")
    public String toHrRegister(){
        return "hrRegister";
    }

    //跳转到招聘详情信息页面
    @RequestMapping("toZhiwei")
    public String toZhiwei(Model model,Integer ids){
        System.out.println(ids+"===========");
        model.addAttribute("ids",ids);
        return "zhiwei";
    }




    //跳转公司职位管理
    @RequestMapping("toZwjl")
    public String toZwjl(){
        return "gsZwjl";
    }
}
