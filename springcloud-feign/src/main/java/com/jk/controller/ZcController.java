package com.jk.controller;

import com.jk.service.XxfService;
import com.jk.service.ZcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
@Controller
public class ZcController {
    @Autowired
    private ZcService zcService;

    @RequestMapping("zcTest")
    @ResponseBody
    public Map test(){
        return zcService.test();
    }
}
