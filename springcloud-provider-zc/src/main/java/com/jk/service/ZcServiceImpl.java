package com.jk.service;
import com.jk.dao.ZcDao;
import com.jk.model.*;
import com.jk.model.Book;
import com.jk.model.JianLi;
import com.jk.model.Zwjl;
import com.jk.model.zcModel.UserModel;
import com.jk.util.ResultPage;
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
    public List<Gsyh> hotCompany() {
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

    //企业版注册
    @Override
    public void businessRegistrations(User user) {

        zcDao.businessRegistrations(user);
    }

    //企业版登录
    @Override
    public HashMap<String, Object> companiesIn(User user) {
        HashMap<String, Object> map = new HashMap<>();
        User userModel = zcDao.companiesIn(user);
        //判断用户是否存在
        if(userModel==null){
            map.put("code",0);
            map.put("msg","账号错误");
            return map;
        }
        //判断密码是否一致
        String pwd = user.getPassword();
        if(!pwd.equals(userModel.getPassword())){
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

    //查询简历
    @Override
    public JianLi queryTheResume(Integer ids) {
        return zcDao.queryTheResume(ids);
    }

    //修改简历
    @Override
    public void updHighcharts(JianLi jianLi) {
        zcDao.updHighcharts(jianLi);
    }

    //加载公司详情
    @Override
    public Gsyh loaTheCompanyDetails(Integer ids) {
        return zcDao.loaTheCompanyDetails(ids);
    }

    //查询对应公司发布的职位
    @Override
    public List<Zwjl> zcPostAPosition(String ids) {
        return zcDao.zcPostAPosition(ids);
    }

    //加载面试官姓名
    @Override
    public Zwjl loadHrName(String ids) {
        return zcDao.loadHrName(ids);
    }

    //查询简历
    @Override
    public ResultPage queryZcJianLi(ResultPage resultPage) {
        ResultPage result = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<>();
        //hashMap.put("user", user);
        //查询总条数
        Integer count = zcDao.queryZcJianLiCount(hashMap);
        resultPage.setTotal(count);

        hashMap.put("startIndex", (resultPage.getPageNumber()-1)*resultPage.getPageSize());
        hashMap.put("endIndex", resultPage.getPageSize());
        //查询list
        List<JianLi> list = zcDao.queryZcJianLi(hashMap);
        resultPage.setRows(list);
        return resultPage;
    }


}
