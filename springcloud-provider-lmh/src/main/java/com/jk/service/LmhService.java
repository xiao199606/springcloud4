package com.jk.service;

import javax.servlet.http.HttpServletRequest;

public interface LmhService {
    Boolean sendMails(HttpServletRequest request,String email);

    Boolean failureMails(HttpServletRequest request,String email);

    void updateJianLi();
}
