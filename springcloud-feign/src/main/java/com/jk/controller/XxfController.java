package com.jk.controller;


import com.jk.config.EsConfig;
import com.jk.dao.JworkRepository;
import com.jk.model.Gsyh;
import com.jk.model.Leib;
import com.jk.model.Tree;
import com.jk.model.Zwjl;
import com.jk.model.zcModel.UserModel;
import com.jk.service.XxfService;
import com.jk.util.ResultPage;
import com.jk.util.TreeNoteUtil;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class XxfController {

    @Autowired
    private XxfService XxfService;
    @Autowired
    private JworkRepository jworkRepository;



    @GetMapping("toAddZwjl")
    public String toAddZwjl(){
        return "addZwjl";
    }


    @GetMapping("findZwjlById")
    public String findZwjlById(Integer id, Model model){
        Zwjl zwjl=XxfService.findZwjlById(id);
        model.addAttribute("z",zwjl);
        return "updateZwjl";
    }




    @GetMapping("getAllTree")
    @ResponseBody
    public List<Tree> getTreeAll() {
        List<Tree> list = new ArrayList();
        list = XxfService.getTreeAll();
        list = TreeNoteUtil.getFatherNode(list);
        return list;
    }


    @GetMapping("queryleib")
    @ResponseBody
    public List<Leib> queryleib() {
        return XxfService.queryleib();
    }


    @GetMapping("addgsZwjl")
    @ResponseBody
    public void addgsZwjl(Zwjl zwjl,HttpServletRequest request) {
        //   这是个啥？？？
        Integer id = (Integer) request.getSession().getAttribute("id");
        zwjl.setZhiw("测试");
        //测试 给一个公司的id 可能要根据公司的id查询出公司的数据 在赋值给职位
        zwjl.setGsid(2);
        Gsyh gsyh= XxfService.querygsbyid(zwjl.getGsid());
        zwjl.setGongsmc(gsyh.getGongsmc());
        zwjl.setYuangrs(gsyh.getYuangrs());
        zwjl.setGongsxz(gsyh.getGongsxz());
        //添加返回主键 zid
        //向搜索引擎添加
       Integer zid= XxfService.addgsZwjl(zwjl);
        zwjl.setId(zid);
        try {
        jworkRepository.save(zwjl);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @PostMapping("updateZwjl")
    @ResponseBody
    public void updateZwjl(Zwjl zwjl) {
        XxfService.updateZwjl(zwjl);
    }


    @PostMapping("deleteZwjl")
    @ResponseBody
    public boolean deleteZwjl(String ids) {
        try {
            XxfService.deleteResume(ids);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }






    @GetMapping("queryZwjl")
    @ResponseBody
    public ResultPage queryZwjl(ResultPage resultPage, HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute("id");
        resultPage.setGsyhid(id);
        return XxfService.queryZwjl(resultPage);
    }


}
