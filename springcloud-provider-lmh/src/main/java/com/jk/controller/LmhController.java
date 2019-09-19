package com.jk.controller;

import com.jk.service.LmhService;
import com.jk.service.LmhServiceApi;
import com.jk.service.XxfServiceApi;
import com.netflix.client.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class LmhController {

    @Autowired
    private LmhService lmhServiceApi;

    @PostMapping("/sendMails")
    public Boolean sendMails(HttpServletRequest request) {

        try {
            lmhServiceApi.sendMails(request);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping("failureMails")
    public Boolean failureMails(HttpServletRequest request) {

        try {
            lmhServiceApi.failureMails(request);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping
    public  Boolean updateJianLi(){
        try {
            lmhServiceApi.updateJianLi();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
