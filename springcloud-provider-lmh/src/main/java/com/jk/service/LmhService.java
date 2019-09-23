package com.jk.service;

import com.jk.model.JianLi;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LmhService {
    Boolean sendMails(HttpServletRequest request);

    Boolean failureMails(HttpServletRequest request);

    void updateJianLi();

    List<JianLi> queryJianL(Integer ids1);
}
