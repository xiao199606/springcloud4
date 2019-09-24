package com.jk.controller;

import com.jk.model.JianLi;
import com.jk.service.LmhServiceApi;
import com.jk.utils.ExportExcel;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@RestController
@RequestMapping("lmh")
public class LmhController {

    @Autowired
    private  LmhServiceApi lmhServiceApi;
    @PostMapping("/sendMails")
    public Boolean sendMails(String email) {

        try {
            lmhServiceApi.sendMails(email);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping("failureMails")
    public Boolean failureMails(String email) {
        try {
            lmhServiceApi.failureMails(email);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


    @PostMapping("aaa")
    public void timer1(Integer id){
        System.out.println(id);
        Timer nTimer = new Timer();
        nTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateJianLi(id);
            }
        },20000);
    }

    @PostMapping
    public  Boolean updateJianLi(Integer id){
        try {
            lmhServiceApi.updateJianLi(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
