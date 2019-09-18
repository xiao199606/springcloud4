package com.jk.controller;

import com.jk.service.XxfService;
import com.jk.service.ZcService;
import com.jk.utils.CheckSumBuilder;
import com.jk.utils.HttpClientUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class ZcController {
    @Autowired
    private ZcService zcService;

    //测试
    @RequestMapping("zcTest")
    @ResponseBody
    public Map test(){
        return zcService.test();
    }

    //短信验证码接口
    @RequestMapping("httpNote")
    @ResponseBody
    public String  httpNote(){
        String url = "https://api.netease.im/sms/sendcode.action";
        String CurTime=String.valueOf(new Date().getTime());
        String Nonce= UUID.randomUUID().toString().replace("-", "");

        HashMap<String, Object> headers = new HashMap<String, Object>();
        //开发者平台分配的appkey
        headers.put("AppKey", "ccc4db070c604bc77ce5f57e533f04f1");
        //随机数（最大长度128个字符）
        headers.put("Nonce", Nonce);
        //当前UTC时间戳，从1970年1月1日0点0 分0 秒开始到现在的秒数(String)
        headers.put("CurTime", CurTime);
        //SHA1(AppSecret + Nonce + CurTime),三个参数拼接的字符串，进行SHA1哈希计算，转化成16进制字符(String，小写)
        headers.put("CheckSum", CheckSumBuilder.getCheckSum("777d8b9503f8", Nonce, CurTime));


        HashMap<String, Object> params = new HashMap<String, Object>();
        //手机号
        params.put("mobile","17610262938");
        params.put("templateid",14801340);

        try {//parseObject
            String str=HttpClientUtil.post(url, params, headers);
            //JSONObject jsonObject = JSONObject.parseObject(str);
            JSONObject jsonObject = new JSONObject(str);
            String code=jsonObject.getString("code");
            System.out.println(str);
            if("200".equals(code)){
                System.out.println("=======");


            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "0";
    }
}
