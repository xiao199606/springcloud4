package com.jk.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface LmhServiceApi {

    @PostMapping("sendMails")
    Boolean sendMails(@RequestParam("email") String email);
    @PostMapping("failureMails")
    Boolean failureMails(@RequestParam("email") String email);
    @PostMapping
    void updateJianLi();
}
