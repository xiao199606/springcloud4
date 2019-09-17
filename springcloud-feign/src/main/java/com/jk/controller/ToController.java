package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
}
