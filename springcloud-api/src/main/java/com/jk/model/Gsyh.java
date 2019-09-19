package com.jk.model;

import java.util.Date;

public class Gsyh {
    private Integer id;

    private String email;

    private Date zhucsj;

    private String gongsmc;

    private String yuangrs;

    private String diq;

    private String gongsxz;

    private Date chenglrq;

    private String zhuczj;

    private String gongsjj;

    private String lianxr;

    private String lianxtel;

    private String adress;

    private String qq;

    private String web;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getZhucsj() {
        return zhucsj;
    }

    public void setZhucsj(Date zhucsj) {
        this.zhucsj = zhucsj;
    }

    public String getGongsmc() {
        return gongsmc;
    }

    public void setGongsmc(String gongsmc) {
        this.gongsmc = gongsmc == null ? null : gongsmc.trim();
    }

    public String getYuangrs() {
        return yuangrs;
    }

    public void setYuangrs(String yuangrs) {
        this.yuangrs = yuangrs == null ? null : yuangrs.trim();
    }

    public String getDiq() {
        return diq;
    }

    public void setDiq(String diq) {
        this.diq = diq == null ? null : diq.trim();
    }

    public String getGongsxz() {
        return gongsxz;
    }

    public void setGongsxz(String gongsxz) {
        this.gongsxz = gongsxz == null ? null : gongsxz.trim();
    }

    public Date getChenglrq() {
        return chenglrq;
    }

    public void setChenglrq(Date chenglrq) {
        this.chenglrq = chenglrq;
    }

    public String getZhuczj() {
        return zhuczj;
    }

    public void setZhuczj(String zhuczj) {
        this.zhuczj = zhuczj == null ? null : zhuczj.trim();
    }

    public String getGongsjj() {
        return gongsjj;
    }

    public void setGongsjj(String gongsjj) {
        this.gongsjj = gongsjj == null ? null : gongsjj.trim();
    }

    public String getLianxr() {
        return lianxr;
    }

    public void setLianxr(String lianxr) {
        this.lianxr = lianxr == null ? null : lianxr.trim();
    }

    public String getLianxtel() {
        return lianxtel;
    }

    public void setLianxtel(String lianxtel) {
        this.lianxtel = lianxtel == null ? null : lianxtel.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web == null ? null : web.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}