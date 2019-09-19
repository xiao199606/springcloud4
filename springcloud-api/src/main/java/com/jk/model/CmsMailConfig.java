package com.jk.model;

import lombok.Data;

@Data
public class CmsMailConfig {

    private Integer mailId;

    /**
     * 邮箱账号
     */
    private String mailAccount;

    /**
     * 授权码
     */
    private String mailLicense;

    /**
     * 状态，0：使用，1：未使用
     */
    private String isUse;

    /**
     * 是否删除，0：否，1：是
     */
    private String isDelete;

    /**
     * 创建者ID
     */
    private Integer createAdminId;

    private String extend1;

    private String extend2;

    private String extend3;

    private String extend4;

    private String extend5;

    private String extend6;
}
