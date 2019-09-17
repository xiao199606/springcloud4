package com.jk.controller;

import com.jk.service.XxfServiceApi;
import com.jk.service.ZcServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ZcController {
    @Autowired
    private ZcServiceApi zcService;

    @RequestMapping("/zcTest")
    public Map test(){
        Map map=zcService.test();
        return map;
    }
}
