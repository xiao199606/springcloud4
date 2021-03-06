package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class GsyhModel {

    private Integer id;//Id

    private String email;//邮箱

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date zhucsj;//注册时间

    private String gongsmc;//公司名称

    private String yuangrs;//员工人数

    private String diq;//所在地区

    private String gongsxz;//公司性质

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date chenglrq;//成立日期

    private String zhuczj;//注册资金

    private String gongsjj;//公司简介

    private String lianxr;//联系人

    private String lianxtel;//练习电话

    private String adress;//公司地址

    private String qq;//在线洽谈QQ

    private String web;//公司网站


}
