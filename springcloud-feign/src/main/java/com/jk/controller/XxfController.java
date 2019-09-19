package com.jk.controller;


import com.jk.model.Leib;
import com.jk.model.Tree;
import com.jk.model.Zwjl;
import com.jk.model.zcModel.UserModel;
import com.jk.service.XxfService;
import com.jk.util.ResultPage;
import com.jk.util.TreeNoteUtil;
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


    @PostMapping("addgsZwjl")
    @ResponseBody
    public void addgsZwjl(Zwjl zwjl,HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute("id");
        zwjl.setGsid(id);
        XxfService.addgsZwjl(zwjl);
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
