package com.jk.service;

import javax.servlet.http.HttpServletRequest;

public interface LmhService {
    Boolean sendMails(HttpServletRequest request);

    Boolean failureMails(HttpServletRequest request);

    void updateJianLi();
}
