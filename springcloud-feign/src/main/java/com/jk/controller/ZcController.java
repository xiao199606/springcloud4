package com.jk.controller;

import com.jk.model.Gsyh;
import com.jk.model.JianLi;
import com.jk.model.User;
import com.jk.model.Zwjl;
import com.jk.model.zcModel.UserModel;
import com.jk.service.XxfService;
import com.jk.service.ZcService;
import com.jk.util.OSSClientUtil;
import com.jk.util.ResultPage;
import com.jk.utils.CheckSumBuilder;
import com.jk.utils.HttpClientUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("zcController")
public class ZcController {
    @Autowired
    private ZcService zcService;
    //@Autowired
    //private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;

    //短信验证码接口
    @RequestMapping("httpNote")
    @ResponseBody
    public String httpNote(String phone) {
        String url = "https://api.netease.im/sms/sendcode.action";
        String CurTime = String.valueOf(new Date().getTime());
        String Nonce = UUID.randomUUID().toString().replace("-", "");

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
        params.put("mobile", phone);
        params.put("templateid", 14842059);

        try {//parseObject
            String str = HttpClientUtil.post(url, params, headers);
            //JSONObject jsonObject = JSONObject.parseObject(str);
            JSONObject jsonObject = new JSONObject(str);
            String code = jsonObject.getString("code");
            String obj = jsonObject.getString("obj");
            //把验证码返回到前台
            if ("200".equals(code)) {
                System.out.println(jsonObject);
                return obj;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "0";
    }

    //个人版注册
    @RequestMapping("zcRegister")
    @ResponseBody
    public String zcRegister(JianLi jianLi) {
        //随机生成密码
        String random = (int) ((Math.random() * 9 + 1) * 100000) + "";
        jianLi.setPwd(random);
        zcService.zcRegister(jianLi);
        return random;
    }

    //个人版登录
    @RequestMapping("grDenLu")
    @ResponseBody
    public HashMap<String, Object> grDenLu(UserModel user,HttpSession session) {
        HashMap<String, Object> map = zcService.grDenLu(user);
        Integer ids = (Integer) map.get("ids");
        session.setAttribute("ids",ids);
        Integer ids1 = (Integer) session.getAttribute("ids");
        System.out.println(ids1+"用户Id");
        return map;
    }

    //企业版版登录
    @RequestMapping("companiesIn")
    @ResponseBody
    public HashMap<String, Object> companiesIn(User user,HttpSession session) {
        HashMap<String, Object> map = zcService.companiesIn(user);
        //获取map存入定的Id
        Integer ids = (Integer) map.get("ids");

        session.setAttribute("ids2",ids);
        Integer ids1 = (Integer) session.getAttribute("ids2");

        System.out.println(ids1+"企业用户Id");
        return map;
    }


    //查询已发布职位
    @RequestMapping("zcIssue")
    @ResponseBody
    public List<Zwjl> zcIssue() {
        List<Zwjl> zwjls = zcService.zcIssue();
        return zwjls;
    }

    //查询对应公司发布的职位
    @RequestMapping("zcPostAPosition")
    @ResponseBody
    public List<Zwjl> zcPostAPosition(String ids){
        List<Zwjl> list = zcService.zcPostAPosition(ids);
        return list;
    }

    //查询热门公司
    @RequestMapping("hotCompany")
    @ResponseBody
    public List<Gsyh> hotCompany() {
        List<Gsyh> Gsyh = zcService.hotCompany();
        return Gsyh;
    }

    //加载招聘详情页
    @RequestMapping("loadParticulars")
    @ResponseBody
    public Zwjl loadParticulars(String ids) {
        return zcService.loadParticulars(ids);
    }

    //阿里云上传图片
    @RequestMapping("updaloadImg")
    @ResponseBody
    public String uploadImg(MultipartFile img)throws IOException {
        System.out.println(img+"=============");
        if (img == null || img.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(img);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        //System.out.println(split[0]);
        return split[0];
    }

    //企业版注册
    @RequestMapping("businessRegistration")
    @ResponseBody
    public String businessRegistration(User user){
        System.out.println(user);
        //随机生成密码
        String random = (int) ((Math.random() * 9 + 1) * 100000) + "";
        user.setPassword(random);
        zcService.businessRegistrations(user);
        return random;
    }

    //加载公司
    @RequestMapping("loadCompany")
    @ResponseBody
    public List<Gsyh> loadCompany(){
        List<Gsyh> userList = zcService.loadCompany();
        return userList;
    }

    //跳转到修改简历
    @RequestMapping("toTheResume")
    public String toTheResume(HttpServletRequest request, Model model){
        Integer ids = (Integer) request.getSession().getAttribute("ids");
        JianLi jianLi = zcService.queryTheResume(ids);
        model.addAttribute("model",jianLi);
        return "updHighcharts";
    }

    //修改简历
    @RequestMapping("updJianLi")
    @ResponseBody
    public Boolean updHighcharts(JianLi jianLi){
        //System.out.println(jianLi.getId()+"=======================");
        if(jianLi.getId()!=null){
            zcService.updHighcharts(jianLi);
            return true;
        }
        return false;
    }

    //加载公司详情
    @RequestMapping("loaTheCompanyDetails")
    @ResponseBody
    public  Gsyh loaTheCompanyDetails(Integer ids){
        return zcService.loaTheCompanyDetails(ids);
    }

    //加载面试官姓名
    @RequestMapping("loadHrName")
    @ResponseBody
    public Zwjl loadHrName(String ids){

        return zcService.loadHrName(ids);
    }

    //新增到聊天记录
    @RequestMapping("addTransmit")
    @ResponseBody
    public HashMap addTransmit(String hrName,String re,HttpSession session){

        HashMap<String, String> map = new HashMap<>();
        Integer ids1 = (Integer) session.getAttribute("ids");
        //个人用户Id加面试官姓名 生成唯一的key
        String transmit = "transmit"+ids1+hrName;

        //判断
        if(redisTemplate.hasKey(transmit)){
            redisTemplate.opsForValue().set(transmit,re);
            //再次查询
            String s1 = redisTemplate.opsForValue().get(transmit);
            map.put("code",s1);
            return map;
        }
        //如果不存在先新增到数据库在查询
        redisTemplate.opsForValue().set(transmit,re);
        String s = redisTemplate.opsForValue().get(transmit);
        map.put("code",s);
        return map;
    }

    //加载聊天信息
    @RequestMapping("loadTransmit")
    @ResponseBody
    public HashMap loadTransmit(HttpSession session){
        HashMap<String, String> map = new HashMap<>();
        Integer ids1 = (Integer) session.getAttribute("ids");
        String s = redisTemplate.opsForValue().get("transmit"+ids1);
        map.put("code",s);
        return map;
    }

    //查询简历
    @RequestMapping("queryZcJianLi")
    @ResponseBody
    public ResultPage queryZcJianLi(ResultPage resultPage){
        return zcService.queryZcJianLi(resultPage);
    }

}
