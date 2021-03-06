package com.jk.service;

import com.jk.model.JianLi;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LmhServiceApi {

    @PostMapping("sendMails")
    Boolean sendMails(@RequestParam("email") String email);
    @PostMapping("failureMails")
    Boolean failureMails(@RequestParam("email") String email);
    @PostMapping
    void updateJianLi(@RequestParam(value = "id",required = true) Integer id);

    @PostMapping("queryJianL")
    List<JianLi> queryJianL(@RequestParam(value = "ids1",required = true) Integer ids1);
}
