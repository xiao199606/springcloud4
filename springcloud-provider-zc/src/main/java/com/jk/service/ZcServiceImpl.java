package com.jk.service;
import com.jk.dao.ZcDao;
import com.jk.model.*;
import com.jk.model.zcModel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZcServiceImpl implements ZcServiceApi {
    @Autowired
    private ZcDao zcDao;



    //个人版注册
    @Override
    public void zcRegister(JianLi jianLi) {
        //新增简历
        zcDao.zcRegister(jianLi);
        //根据手机号 查询 新增后简历的的主键Id
        String tel = jianLi.getTel();
        Integer tell = zcDao.queryCellPhoneNumber(tel);

        //新增注册信息
        UserModel userModel = new UserModel();
        userModel.setJianLiId(tell);
        userModel.setTel(jianLi.getTel());
        userModel.setPwd(jianLi.getPwd());
        userModel.setEmail(jianLi.getEmail());
        zcDao.addPersonalUser(userModel);

        zcDao.zcRegister(jianLi);
    }

    //个人版登录
    @Override
    public HashMap<String, Object> grDenLu(UserModel user) {
        HashMap<String, Object> map = new HashMap<>();
        UserModel userModel = zcDao.queryTel(user);
        //判断用户是否存在
        if(userModel==null){
            map.put("code",0);
            map.put("msg","账号错误");
            return map;
        }
        //判断密码是否一致
        String pwd = user.getPwd();
        if(!pwd.equals(userModel.getPwd())){
            map.put("code",1);
            map.put("msg","密码错误");
            return map;
        }
        map.put("code",2);
        //获取用户Id
        Integer ids = userModel.getId();
        map.put("ids", ids);
        return map;
    }


    //查询已发布职位
    @Override
    public List<Zwjl> zcIssue() {
        return zcDao.zcIssue();
    }

    //查询热门职位
    @Override
    public List<Zwjl> hotCompany() {
        return zcDao.hotCompany();
    }

    //查询招聘详情页
    @Override
    public Zwjl loadParticulars(String ids) {
        return zcDao.loadParticulars(ids);
    }

    //加载所有公司
    @Override
    public List<Gsyh> loadCompany() {
        return zcDao.loadCompany();
    }


}
