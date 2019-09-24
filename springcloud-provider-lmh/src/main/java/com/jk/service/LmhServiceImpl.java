package com.jk.service;

import com.jk.dao.LmhDao;
import com.jk.model.*;
import com.jk.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class LmhServiceImpl implements LmhService {

    @Autowired
    private MailUtils mailUtils;

    @Autowired
    private LmhDao lmhDao;
    @Override
    public Boolean sendMails(HttpServletRequest request,String email) {
        User user = (User) request.getSession().getAttribute("User");
        if(user!=null){
            Integer id = user.getId();
            //根据用户id找到用户对应的信息

        }
        MailVo mailVo = new MailVo();
        mailVo.setMailTiTle("面试邀请");
        mailVo.setMailContent("您已接收到XXX公司的面试邀请，请您在2019-12-1下午3点到我们公司面试。地点XXX");
        mailVo.setRecipients(email);
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


    @Override
    public Boolean failureMails(HttpServletRequest request,String email) {
        User user = (User) request.getSession().getAttribute("User");
        if(user!=null){
            Integer id = user.getId();
            //根据用户id找到用户对应的信息
        }
        MailVo mailVo = new MailVo();
        mailVo.setMailTiTle("简历违规提醒");
        mailVo.setMailContent("您的简历存在违规字符，请您修改后重新投放。"+"<a herf=''>投放地址</a>");
        if(email==null){
            mailVo.setRecipients("646187818@qq.com");
        }else{
            mailVo.setRecipients(email);
        }
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

    @Override
    public void updateJianLi(Integer id) {
        Gryh gryh = lmhDao.queryjian(id);
        System.out.println(id);
       System.out.println(gryh.getJianLiId());
        lmhDao.updateJianLi(gryh.getJianLiId());
    }

    @Override
    public List<JianLi> queryJianL(Integer ids1) {
        return lmhDao.queryJianL(ids1);
    }
}
