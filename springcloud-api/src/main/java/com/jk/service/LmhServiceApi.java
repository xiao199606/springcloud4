package com.jk.service;

import com.jk.model.JianLi;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LmhServiceApi {

    @PostMapping("sendMails")
    Boolean sendMails();
    @PostMapping("failureMails")
    Boolean failureMails();
    @PostMapping
    void updateJianLi();

    @PostMapping("queryJianL")
    List<JianLi> queryJianL(@RequestParam(value = "ids1",required = true) Integer ids1);
}
