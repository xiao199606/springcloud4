package com.jk.controller;

import com.jk.model.zcModel.UserModel;
import com.jk.service.XxfService;
import com.jk.service.ZcService;
import com.jk.utils.CheckSumBuilder;
import com.jk.utils.HttpClientUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("zcController")
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
    public String  httpNote(String phone){
        String url = "https://api.netease.im/sms/sendcode.action";
        String CurTime=String.valueOf(new Date().getTime());
        String Nonce= UUID.randomUUID().toString().replace("-", "");

        HashMap<String, Object> headers = new HashMap<String, Object>();
        //开发者平台分配的appkey
        headers.put("AppKey", "e9ecfdeb9cabe98eb14c0613785af814");
        //随机数（最大长度128个字符）
        headers.put("Nonce", Nonce);
        //当前UTC时间戳，从1970年1月1日0点0 分0 秒开始到现在的秒数(String)
        headers.put("CurTime", CurTime);
        //SHA1(AppSecret + Nonce + CurTime),三个参数拼接的字符串，进行SHA1哈希计算，转化成16进制字符(String，小写)
        headers.put("CheckSum", CheckSumBuilder.getCheckSum("3ef4903ad9e1", Nonce, CurTime));


        HashMap<String, Object> params = new HashMap<String, Object>();
        //手机号
        params.put("mobile",phone);
        params.put("templateid",14841054);

        try {//parseObject
            String str=HttpClientUtil.post(url, params, headers);
            //JSONObject jsonObject = JSONObject.parseObject(str);
            JSONObject jsonObject = new JSONObject(str);
            String code=jsonObject.getString("code");
            String obj=jsonObject.getString("obj");
            //把验证码返回到前台
            if("200".equals(code)){
                System.out.println(jsonObject);
                return obj;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "0";
    }

    //注册
    @RequestMapping("zcRegister")
    @ResponseBody
    public String zcRegister(String phone,UserModel userModel){
        userModel.setTel(phone);
        //随机生成密码
        String random=(int)((Math.random()*9+1)*100000)+"";
        userModel.setPwd(random);
        zcService.zcRegister(userModel);
        return random;
    }

    //个人版登录
    @RequestMapping("grDenLu")
    @ResponseBody
    public HashMap<String,Object> grDenLu(UserModel userModel){
        return zcService.grDenLu(userModel);
    }
}