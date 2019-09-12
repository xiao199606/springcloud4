package com.jk.controller;

import com.jk.service.XxfServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class XxfController {
    @Autowired
    private XxfServiceApi XxfService;

    @RequestMapping("/test")
    public Map test(){
        Map map=XxfService.test();
        return map;
    }
}
