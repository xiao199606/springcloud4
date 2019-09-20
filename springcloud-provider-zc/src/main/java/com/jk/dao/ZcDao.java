package com.jk.dao;

import com.jk.model.*;
import com.jk.model.zcModel.UserModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZcDao {

    //新增简历
    void zcRegister(JianLi jianLi);

    //查询用户
    //@Select("select *  from  gryh WHERE tel = #{value} and and state = #{tel}")
    UserModel queryTel(UserModel userModel);

    //查询已发布职位
    List<Zwjl> zcIssue();

    //查询热门公司
    List<Zwjl> hotCompany();


    Zwjl loadParticulars(String ids);

    //查询简历主键Id
    @Select("select id from  jianli WHERE tel = #{value}")
    Integer queryCellPhoneNumber(String tel);

    //个人版注册
    void addPersonalUser(UserModel userModel);

    @Select("select id,gongsmc  from  gsyh")
    List<Gsyh> loadCompany();
}
