package com.jk.controller;

import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.HbServiceApi;
import com.jk.service.XxfServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HbController {
    @Autowired
    private HbServiceApi hbServiceApi;

    @RequestMapping("/test")
    public Map test(){
        Map map=hbServiceApi.test();
        return map;
    }

    @RequestMapping("login")
    public User login(String username){
        return hbServiceApi.login(username);
    }

    @RequestMapping("getAllTree")
    public List<Tree> getTreeAll(){
       return  hbServiceApi.getTreeAll();
    }

}
