package com.jk.model.zcModel;

import java.util.Date;

public class UserModel {
    private Integer id;

    private String username;

    private String pwd;

    private String tel;

    private Date zhucsj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getZhucsj() {
        return zhucsj;
    }

    public void setZhucsj(Date zhucsj) {
        this.zhucsj = zhucsj;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", tel='" + tel + '\'' +
                ", zhucsj=" + zhucsj +
                '}';
    }
}
