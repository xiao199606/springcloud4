package com.jk.dao;

import com.jk.model.*;
import com.jk.model.zcModel.UserModel;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
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
    List<Gsyh> hotCompany();


    Zwjl loadParticulars(String ids);

    //查询简历主键Id
    @Select("select id from  jianli WHERE tel = #{value}")
    Integer queryCellPhoneNumber(String tel);

    //个人版注册
    void addPersonalUser(UserModel userModel);

    @Select("select id,gongsmc  from  gsyh where state = 2")
    List<Gsyh> loadCompany();

    //企业版注册
    void businessRegistrations(User user);

    //查询企业版用户
    User companiesIn(User user);

    //查询简历
    @Select("select *  from  jianli where gid = #{value}")
    JianLi queryTheResume(Integer ids);

    //修改简历
    void updHighcharts(JianLi jianLi);

    //加载公司详情
    @Select("select *  from gsyh WHERE id = #{value}")
    Gsyh loaTheCompanyDetails(Integer ids);

    //查询对应公司发布的职位
    List<Zwjl> zcPostAPosition(String ids);

    //查询面试官姓名
    @Select("select lianxr  from  zwjl where id = #{value}")
    Zwjl loadHrName(String ids);

    //查询简历总条数
    Integer queryZcJianLiCount(HashMap<String, Object> hashMap);

    //查询简历所有数据
    List<JianLi> queryZcJianLi(HashMap<String, Object> hashMap);
}
