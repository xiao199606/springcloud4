package com.jk.service;

import com.jk.model.JianLi;
import com.jk.model.Zwjl;
import com.jk.model.zcModel.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ZcServiceApi {

    @GetMapping(value="zcRegister")
    void zcRegister(@RequestBody JianLi jianLi);

    @GetMapping(value="grDenLu")
    HashMap<String, Object> grDenLu(@RequestBody UserModel user);

    @GetMapping(value="zcHrRegister")
    void zcHrRegister(@RequestBody UserModel userModel);

    @GetMapping(value="zcIssue")
    List<Zwjl> zcIssue();

    @GetMapping(value="hotCompany")
    List<Zwjl> hotCompany();

    @GetMapping(value="loadParticulars")
    Zwjl loadParticulars(@RequestParam(value = "ids") String ids);

}
