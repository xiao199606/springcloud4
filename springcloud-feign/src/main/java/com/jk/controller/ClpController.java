package com.jk.controller;


import com.jk.service.ClpService;
import com.jk.util.PageRowsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("toGuanggao")
    public String toGuanggao(){
        return "shenheGuanggao";
    }

    @RequestMapping("toZhewei")
    public String toZhewei(){
        return "shenheZhewei";
    }

    @RequestMapping("toShenheUser")
    public String toShenheUser(){
        return "shenheUser";
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


    //广告审核

    @RequestMapping("queryGuanggao")
    @ResponseBody
    public Map queryGuanggao(PageRowsUtil pageRowsUtil){
        return clpService.queryGuanggao(pageRowsUtil);
    }

    @RequestMapping("updateGgYes")
    @ResponseBody
    public void updateGgYes(Integer id){
        clpService.updateGgYes(id);
    }

    @RequestMapping("deleteGgNo")
    @ResponseBody
    public void deleteGgNo(Integer id){
        clpService.deleteGgNo(id);
    }




    @RequestMapping("queryZhiwei")
    @ResponseBody
    public Map queryZhiwei(PageRowsUtil pageRowsUtil){
        return clpService.queryZhiwei(pageRowsUtil);
    }

    @RequestMapping("updateZhiweiYes")
    @ResponseBody
    public void updateZhiweiYes(Integer id){
        clpService.updateZhiweiYes(id);
    }

    @RequestMapping("updateZhiweiNo")
    @ResponseBody
    public void updateZhiweiNo(Integer id){
        clpService.updateZhiweiNo(id);
    }




    @RequestMapping("deleteZhiweiNo")
    @ResponseBody
    public void deleteZhiweiNo(Integer id){
        clpService.deleteZhiweiNo(id);
    }



    //公司人员审核
    @RequestMapping("queryShenheUser")
    @ResponseBody
    public Map queryShenheUser(PageRowsUtil pageRowsUtil){
        return clpService.queryShenheUser(pageRowsUtil);
    }

    @RequestMapping("updateShenheYes")
    @ResponseBody
    public void updateShenheYes(Integer id){
        clpService.updateShenheYes(id);
    }

    @RequestMapping("deleteShenheNo")
    @ResponseBody
    public void deleteShenheNo(Integer id){
        clpService.deleteShenheNo(id);
    }



    //员工  简历管理


    @RequestMapping("queryYuangongJianli")
    @ResponseBody
    public Map queryYuangongJianli(PageRowsUtil pageRowsUtil){
        return clpService.queryYuangongJianli(pageRowsUtil);
    }



}
