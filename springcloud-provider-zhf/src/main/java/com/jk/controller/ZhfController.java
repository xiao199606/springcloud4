package com.jk.controller;

import com.jk.service.XxfServiceApi;
import com.jk.service.ZhfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ZhfController {
    @Autowired
    private ZhfServiceImpl zhfService;

}
