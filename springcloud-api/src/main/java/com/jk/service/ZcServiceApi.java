package com.jk.service;

import com.jk.model.Gsyh;
import com.jk.model.JianLi;
import com.jk.model.User;
import com.jk.model.Zwjl;
import com.jk.model.zcModel.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ZcServiceApi {


    @GetMapping(value = "zcRegister")
    void zcRegister(@RequestBody JianLi jianLi);

    @GetMapping(value = "grDenLu")
    HashMap<String, Object> grDenLu(@RequestBody UserModel user);


    @GetMapping(value = "zcIssue")
    List<Zwjl> zcIssue();

    @GetMapping(value = "hotCompany")
    List<Gsyh> hotCompany();

    @GetMapping(value = "loadParticulars")
    Zwjl loadParticulars(@RequestParam(value = "ids") String ids);

    @GetMapping(value = "loadCompany")
    List<Gsyh> loadCompany();

    @GetMapping(value = "businessRegistrations")
    void businessRegistrations(@RequestBody User user);

    @GetMapping(value = "companiesIn")
    HashMap<String, Object> companiesIn(@RequestBody User user);

    @GetMapping(value = "toTheResume")
    JianLi queryTheResume(@RequestParam(value = "ids") Integer ids);

    @GetMapping(value = "updHighcharts")
    void updHighcharts(@RequestBody JianLi jianLi);

    @GetMapping(value = "loaTheCompanyDetails")
    Gsyh loaTheCompanyDetails(@RequestParam(value = "ids") Integer ids);

    @GetMapping(value = "zcPostAPosition")
    List<Zwjl> zcPostAPosition(@RequestParam(value = "ids") String ids);

    @GetMapping(value = "loadHrName")
    Zwjl loadHrName(@RequestParam(value = "ids") String ids);
}
