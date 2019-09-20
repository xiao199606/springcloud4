package com.jk.service;
import com.jk.dao.ZcDao;
import com.jk.model.Book;
import com.jk.model.Zwjl;
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

    @Override
    public Map test() {
        List<Book> list=zcDao.test();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("rows",list);
        return map;
    }

    //注册
    @Override
    public void zcRegister(UserModel userModel) {

        zcDao.zcRegister(userModel);
    }

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
        //企业和个人状态
        Integer state = userModel.getState();
        map.put("state",state);
        //获取用户Id
        Integer ids = userModel.getGsyhid();
        map.put("ids",ids);
        return map;
    }

    @Override
    public void zcHrRegister(UserModel userModel) {
        zcDao.zcHrRegister(userModel);
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


}
