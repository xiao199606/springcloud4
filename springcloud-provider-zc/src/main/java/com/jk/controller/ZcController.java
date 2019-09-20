package com.jk.controller;

import com.jk.model.JianLi;
import com.jk.model.Zwjl;
import com.jk.model.zcModel.UserModel;
import com.jk.service.XxfServiceApi;
import com.jk.service.ZcServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ZcController {
    @Autowired
    private ZcServiceApi zcService;

    //注册
    @RequestMapping("zcRegister")
    public Boolean zcRegister(@RequestBody JianLi jianLi){

        zcService.zcRegister(jianLi);
        return true;
    }

    //个人版登录
    @RequestMapping("grDenLu")
    public HashMap<String,Object> grDenLu(@RequestBody UserModel user){

        return zcService.grDenLu(user);
    }

    //zcHrRegister 企业版注册
    @RequestMapping("zcHrRegister")
    public Boolean zcHrRegister(@RequestBody UserModel userModel){
        
        zcService.zcHrRegister(userModel);
        return true;
    }

    //查询已发布职位
    @RequestMapping("zcIssue")
    public List<Zwjl> zcIssue(){
        return zcService.zcIssue();
    }

    @RequestMapping("hotCompany")
    public List<Zwjl> hotCompany(){
        List<Zwjl> zwjlList = zcService.hotCompany();
        return zwjlList;
    }

    //加载招聘详情页
    @RequestMapping("loadParticulars")
    public Zwjl loadParticulars(@RequestParam(value = "ids") String ids){
        return zcService.loadParticulars(ids);
    }
}
