package com.jk.service;

import com.jk.model.JianLi;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LmhService {
    Boolean sendMails(HttpServletRequest request,String email);

    Boolean failureMails(HttpServletRequest request,String email);

    void updateJianLi(Integer id);

    List<JianLi> queryJianL(Integer ids1);
}
