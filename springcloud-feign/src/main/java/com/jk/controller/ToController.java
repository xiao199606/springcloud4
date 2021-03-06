package com.jk.controller;

import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
    public String toBosShow(HttpSession session){
        Integer ids = (Integer) session.getAttribute("ids");
        if(ids==null){
            return "notLogIn";
        }
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
        return "tree2";
    }

    //后台登录页面
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
    public String addResume(String phone,Model model){
        model.addAttribute("phone",phone);
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
        //发布职位表Id
        model.addAttribute("ids",ids);
        return "zhiwei";
    }

    //跳转公司职位管理
    @RequestMapping("toZwjl")
    public String toZwjl(){
        return "gsZwjl";
    }



    //跳转到企业认证页面
    @RequestMapping("toAuthentication")
    public String toAuthentication(Model model,String phone1){
           model.addAttribute("phone1",phone1);
        return "authentication";
    }

    //跳转公司用户查询
    @RequestMapping("queryCompany")
    public String queryCompany(){
        return "queryCompany";
    }

    //报表查询
    @RequestMapping("highcharts")
    public String highcharts(){
        return "highcharts";
    }



    //公司员工查询
    @RequestMapping("queryUser")
    public String queryuser(){
        return "queryUser";
    }

    //广告查询
    @RequestMapping("queryGuang")
    public String queryGuang(){
        return "queryGuang";
    }

    //广告新增
    @RequestMapping("addGuang")
    public String addGuang(){
        return "addGuang";
    }

    //员工 简历管理
    @RequestMapping("toMianShi")
    public String toMianShi(){
        return "showMianShi";
    }

    //跳转到公司详情页面
    @RequestMapping("toTheCompanyDetails")
    public String toTheCompanyDetails(String ids,Model model){
        model.addAttribute("ids",ids);
        return "gongsi";
    }

    //置顶天数
    @RequestMapping("top")
    public String top(){
        return "top";
    }
    //跳转到招聘职位
    @RequestMapping("toJobVacancy")
    public String toJobVacancy(Model model,String ids){
        model.addAttribute("ids",ids);
        return "gszhiwei";
    }

    //跳转到沟通职位页面
    @RequestMapping("toGouTong")
    public String toGouTong(String ids, Model model, HttpSession session){
        //发布招聘信息表Id
        model.addAttribute("ids",ids);
        //个人版登录Id
        Integer ids2 = (Integer) session.getAttribute("ids");
        model.addAttribute("ids2",ids2);
        return "chat";
    }

    //跳转到企业聊天记录
    @RequestMapping("toHrchat")
    public String toJump(){
        return "hrChat";
    }


}
