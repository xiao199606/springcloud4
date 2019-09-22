package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Guanggao {
    private Integer id;

    private String url;

    private String imgsrc;

    private String delflag;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date startime;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date endtime;

    private String createuser;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date createdate;

    private String audit;

    private Integer payment;

    private Integer lcolumn;

    private Integer state;

    private Integer days;

    private Integer gsid;

    public Integer getGsid() {
        return gsid;
    }

    public void setGsid(Integer gsid) {
        this.gsid = gsid;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc == null ? null : imgsrc.trim();
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag == null ? null : delflag.trim();
    }

    public Date getStartime() {
        return startime;
    }

    public void setStartime(Date startime) {
        this.startime = startime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit == null ? null : audit.trim();
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getLcolumn() {
        return lcolumn;
    }

    public void setLcolumn(Integer lcolumn) {
        this.lcolumn = lcolumn;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}