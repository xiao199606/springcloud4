package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.Zwjl;
import com.jk.model.zcModel.UserModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZcDao {
    List<Book> test();

    //个人版注册
    void zcRegister(UserModel userModel);

    //查询用户
    //@Select("select *  from  gryh WHERE tel = #{value} and and state = #{tel}")
    UserModel queryTel(UserModel userModel);

    //企业版注册
    void zcHrRegister(UserModel userModel);

    //查询已发布职位
    List<Zwjl> zcIssue();

    //查询热门公司
    List<Zwjl> hotCompany();


    Zwjl loadParticulars(String ids);
}
