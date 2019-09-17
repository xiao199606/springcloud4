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

    @RequestMapping("tologin")
    public String tologin(){
        return "index";
    }

    @RequestMapping("tohbtree")
    public String tohbtree(){
        return "tree";
    }
}
