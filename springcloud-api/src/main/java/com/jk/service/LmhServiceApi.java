package com.jk.service;

import org.springframework.web.bind.annotation.PostMapping;

public interface LmhServiceApi {

    @PostMapping("sendMails")
    Boolean sendMails();
    @PostMapping("failureMails")
    Boolean failureMails();
    @PostMapping
    void updateJianLi();
}
