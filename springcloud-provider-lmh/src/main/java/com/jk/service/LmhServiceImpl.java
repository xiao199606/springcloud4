package com.jk.service;

import com.jk.model.CmsMailConfig;
import com.jk.model.MailVo;
import com.jk.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LmhServiceImpl implements LmhServiceApi {

    @Autowired
    private MailUtils mailUtils;
    @Override
    public Boolean sendMails() {

        MailVo mailVo = new MailVo();
        mailVo.setMailTiTle("面试邀请");
        mailVo.setMailContent("您已接收到XXX公司的面试邀请，请您在2019-12-1下午3点到我们公司面试。地点XXX");
        mailVo.setRecipients("543379207@qq.com");
        // 获取当前正在使用的发件人配置
        CmsMailConfig cmsMailConfig = new CmsMailConfig();
        cmsMailConfig.setMailLicense("lmh521123");
        cmsMailConfig.setMailAccount("l15036771517@163.com");
        List<CmsMailConfig> mailConfigList = new ArrayList<>();
        mailConfigList.add(cmsMailConfig);
        if (null == mailConfigList || mailConfigList.size() != 1) {
                 return false;
        }

        try {
            // 发送邮件
            mailUtils.sendMail(Boolean.FALSE, mailVo, null, mailConfigList.get(0));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
