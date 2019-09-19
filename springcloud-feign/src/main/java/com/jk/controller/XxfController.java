package com.jk.controller;


import com.jk.model.Tree;
import com.jk.service.XxfService;
import com.jk.util.ResultPage;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class XxfController {

    @Autowired
    private XxfService XxfService;



    @GetMapping("getAllTree")
    @ResponseBody
    public List<Tree> getTreeAll() {
        List<Tree> list = new ArrayList();
        list = XxfService.getTreeAll();
        list = TreeNoteUtil.getFatherNode(list);
        return list;
    }


    @GetMapping("queryZwjl")
    @ResponseBody
    public ResultPage queryZwjl(ResultPage resultPage) {
        return XxfService.queryZwjl(resultPage);
    }
}
