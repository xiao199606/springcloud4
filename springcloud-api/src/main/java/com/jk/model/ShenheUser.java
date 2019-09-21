package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ShenheUser {
    private Integer id;

    private String username;

    private String password;

    private String tel;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date zhucsj;

    private Integer gsyhid;

    private Integer audit;

    private String dobusiness;

    private Integer status;

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
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Date getZhucsj() {
        return zhucsj;
    }

    public void setZhucsj(Date zhucsj) {
        this.zhucsj = zhucsj;
    }

    public Integer getGsyhid() {
        return gsyhid;
    }

    public void setGsyhid(Integer gsyhid) {
        this.gsyhid = gsyhid;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public String getDobusiness() {
        return dobusiness;
    }

    public void setDobusiness(String dobusiness) {
        this.dobusiness = dobusiness == null ? null : dobusiness.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}