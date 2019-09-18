package com.jk.controller;

import com.jk.service.LmhServiceApi;
import com.jk.service.XxfServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LmhController {

    @Autowired
    private LmhServiceApi lmhServiceApi;

    @PostMapping("/sendMails")
    public Boolean sendMails() {

        try {
            lmhServiceApi.sendMails();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

}
