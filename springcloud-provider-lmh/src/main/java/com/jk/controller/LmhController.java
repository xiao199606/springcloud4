package com.jk.controller;

import com.jk.model.JianLi;
import com.jk.service.LmhService;
import com.jk.service.LmhServiceApi;
import com.jk.service.XxfServiceApi;
import com.netflix.client.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //
    @PostMapping("failureMails")
    public Boolean failureMails(HttpServletRequest request) {

        try {
            lmhServiceApi.failureMails(request);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping
    public Boolean updateJianLi(Integer id) {
        try {
            lmhServiceApi.updateJianLi(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //导出到excel
    @PostMapping("queryJianL")
    public List<JianLi> queryJianL(@RequestParam Integer ids1) {

       return lmhServiceApi.queryJianL(ids1);
    }

}
