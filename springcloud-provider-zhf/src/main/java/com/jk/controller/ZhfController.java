package com.jk.controller;


import com.jk.model.Gryh;
import com.jk.model.Gsyhjianli;
import com.jk.service.ZhfService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ZhfController {
    @Autowired
    private ZhfService2 zhfService2;


    @RequestMapping("querygy")
    public Gryh querygy (@RequestParam("id")Integer id){
        return zhfService2.querygy(id);
    }

    @RequestMapping("toujl")
    public void toujl(@RequestParam("gsid")Integer gsid, @RequestParam("jlid")Integer jlid){
        zhfService2.toujl(gsid,jlid);
    }
}
