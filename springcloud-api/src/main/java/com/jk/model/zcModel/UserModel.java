package com.jk.model.zcModel;

import lombok.Data;

import java.util.Date;
@Data
public class UserModel {
    private Integer id;

    private String username;

    private String pwd;

    private String tel;

    private Date zhucsj;

    private Integer jianLiId;//关联简历Id;

    private String email;//邮箱
    private Integer state;

    private Integer gsyhid;
}
