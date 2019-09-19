package com.jk.controller;


import com.jk.service.ClpService;
import com.jk.util.PageRowsUtil;
import com.jk.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("shenhe")
@Controller
public class ClpController {


    @Autowired
    ClpService clpService;

    @RequestMapping("toJianli")
    public String toJianli(){
        return "shenhejianli";
    }

    @RequestMapping("toGsyh")
    public String toGsyh(){
        return "shenheGsyh";
    }


    //简历审核
    @RequestMapping("queryJianli")
    @ResponseBody
    public Map queryJianli(PageRowsUtil pageRowsUtil){
        return clpService.queryJianli(pageRowsUtil);
    }

    @RequestMapping("updateYes")
    @ResponseBody
    public void updateYes(Integer id){
        clpService.updateYes(id);
    }

    @RequestMapping("deleteNo")
    @ResponseBody
    public void deleteNo(Integer id){
        clpService.deleteNo(id);

    }

    //公司审核
    @RequestMapping("queryGsyh")
    @ResponseBody
    public Map queryGsyh(PageRowsUtil pageRowsUtil){
        return clpService.queryGsyh(pageRowsUtil);
    }
    //updateGsYes  deleteGsNo


    @RequestMapping("updateGsYes")
    @ResponseBody
    public void updateGsYes(Integer id){
        clpService.updateGsYes(id);
    }

    @RequestMapping("deleteGsNo")
    @ResponseBody
    public void deleteGsNo(Integer id){
        clpService.deleteGsNo(id);

    }



}
