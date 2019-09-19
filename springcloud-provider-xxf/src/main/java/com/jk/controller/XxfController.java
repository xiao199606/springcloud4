package com.jk.controller;

import com.jk.model.Tree;
import com.jk.service.XxfServiceApi;
import com.jk.util.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class XxfController {
    @Autowired
    private XxfServiceApi XxfService;



    @RequestMapping("getTreeAll")
    public List<Tree> getTreeAll(){
        return XxfService.getTreeAll();
    }


    @RequestMapping("queryZwjl")
    public ResultPage queryZwjl(@RequestBody ResultPage resultPage){
        return XxfService.queryZwjl(resultPage);
    }

}
