package com.jk.controller;

import com.jk.service.XxfServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class XxfController {
    @Autowired
    private XxfServiceApi XxfService;

}
