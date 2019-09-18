package com.jk.controller;

import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.HbService;
import com.jk.service.HbServiceApi;
import com.jk.service.XxfService;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Hb")
public class HbController {

    @Autowired
    private HbService hbService;

    @RequestMapping("test")
    @ResponseBody
    public Map test(){

        return hbService.test();
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(User user, HttpServletRequest request) {
        User user1 = hbService.login(user.getUsername());
        if (user1 == null) {
            return "1";
        }
        if(!user1.getPassword().equals(user.getPassword())){
            return "2";
        }
        request.getSession().setAttribute("user", user1);
        return "0";
    }

    @RequestMapping("getAllTree")
    @ResponseBody
    public List<Tree> getTreeAll() {
        List<Tree> list = new ArrayList();
        list = hbService.getTreeAll();
        list = TreeNoteUtil.getFatherNode(list);
        return list;
    }
}
