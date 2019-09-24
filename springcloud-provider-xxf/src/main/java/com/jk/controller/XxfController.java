package com.jk.controller;

import com.jk.model.Gsyh;
import com.jk.model.Leib;
import com.jk.model.Tree;
import com.jk.model.Zwjl;
import com.jk.service.XxfServiceApi;
import com.jk.util.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class XxfController {
    @Autowired
    private XxfServiceApi XxfService;



    @RequestMapping("getTreeAll")
    public List<Tree> getTreeAll(){
        return XxfService.getTreeAll();
    }


    @RequestMapping("queryZwjl")
    public ResultPage queryZwjl(@RequestBody ResultPage resultPage){
        return XxfService.queryZwjl(resultPage);
    }

    @RequestMapping("queryleib")
    public List<Leib> queryleib(){
        return XxfService.queryleib();
    }

    @RequestMapping("addgsZwjl")
    public Integer addgsZwjl(@RequestBody Zwjl zwjl){
      Integer zid= XxfService.addgsZwjl(zwjl);
        return zid;
    }

    @RequestMapping("updateZwjl")
    public void updateZwjl(@RequestBody Zwjl zwjl){
        XxfService.updateZwjl(zwjl);
    }

    @RequestMapping("deleteResume")
    public Boolean deleteResume(@RequestParam String ids){
        try {
            XxfService.deleteResume(ids);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("findZwjlById")
    public Zwjl findZwjlById(@RequestParam Integer id){
        return XxfService.findZwjlById(id);
    }

    @RequestMapping("querygsbyid")
    public Gsyh querygsbyid(Integer gsid){

        return XxfService.querygsbyid(gsid);
    }
}
