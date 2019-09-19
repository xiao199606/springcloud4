package com.jk.model;

import lombok.Data;

@Data
public class MailVo {
    /**
     * 邮件标题
     */
    private String mailTiTle;
    /**
     * 邮件内容
     */
    private String mailContent;
    /**
     * 收件人(们)
     */
    private String recipients;
}
