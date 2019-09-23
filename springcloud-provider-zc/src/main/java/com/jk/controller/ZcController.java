package com.jk.controller;

import com.jk.model.JianLi;
import com.jk.model.Gsyh;
import com.jk.model.JianLi;
import com.jk.model.User;
import com.jk.model.Zwjl;
import com.jk.model.zcModel.UserModel;
import com.jk.service.ZcServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ZcController {

    @Autowired
    private ZcServiceApi zcService;


    //个人版注册
    @RequestMapping("zcRegister")
    public Boolean zcRegister(@RequestBody JianLi jianLi) {

        zcService.zcRegister(jianLi);
        return true;
    }

    //个人版登录
    @RequestMapping("grDenLu")
    public HashMap<String, Object> grDenLu(@RequestBody UserModel user) {

        return zcService.grDenLu(user);
    }

    //企业版版登录
    @RequestMapping("companiesIn")
    public HashMap<String, Object> companiesIn(@RequestBody User user) {

        return zcService.companiesIn(user);
    }


    //查询已发布职位
    @RequestMapping("zcIssue")
    public List<Zwjl> zcIssue() {
        return zcService.zcIssue();
    }

    //查询展示公司
    @RequestMapping("hotCompany")
    public List<Gsyh> hotCompany() {
        List<Gsyh> gsyh = zcService.hotCompany();
        return gsyh;
    }

    //加载招聘详情页
    @RequestMapping("loadParticulars")
    public Zwjl loadParticulars(@RequestParam(value = "ids") String ids) {
        return zcService.loadParticulars(ids);
    }

    //加载公司
    @RequestMapping("loadCompany")
    public List<Gsyh> loadCompany(){
        List<Gsyh> userList = zcService.loadCompany();
        return userList;
    }

    //企业版注册
    @RequestMapping("businessRegistrations")
    public void businessRegistration(@RequestBody User user){
        //随机生成密码
        String random = (int) ((Math.random() * 9 + 1) * 100000) + "";
        user.setPassword(random);
        zcService.businessRegistrations(user);
    }

    //跳转到修改简历
    @RequestMapping("toTheResume")
    public JianLi modifyResume(@RequestParam(value = "ids") Integer ids){
        JianLi jianLi = zcService.queryTheResume(ids);
        return jianLi;
    }


    //修改简历
    @RequestMapping("updHighcharts")
    public void updHighcharts(@RequestBody JianLi jianLi){
            zcService.updHighcharts(jianLi);
    }

    //加载公司详情
    @RequestMapping("loaTheCompanyDetails")
    public  Gsyh loaTheCompanyDetails(@RequestParam(value = "ids") Integer ids){
        return zcService.loaTheCompanyDetails(ids);
    }

    //查询对应公司发布的职位
    @RequestMapping("zcPostAPosition")
    public List<Zwjl> zcPostAPosition(@RequestParam(value = "ids") String ids){
        List<Zwjl> list = zcService.zcPostAPosition(ids);
        return list;
    }

    //加载面试官姓名
    @RequestMapping("loadHrName")
    public Zwjl loadHrName(@RequestParam(value = "ids") String ids){

        return zcService.loadHrName(ids);
    }

}
