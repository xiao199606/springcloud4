package com.jk.service;

import com.jk.model.Gsyh;
import com.jk.model.Leib;
import com.jk.model.Tree;
import com.jk.model.Zwjl;
import com.jk.util.ResultPage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface XxfServiceApi {

    @GetMapping("getTreeAll")
    List<Tree> getTreeAll();
    @GetMapping("queryZwjl")
    ResultPage queryZwjl(@RequestBody ResultPage resultPage);
    @GetMapping("queryleib")
    List<Leib> queryleib();
    @GetMapping("addgsZwjl")
    Integer addgsZwjl(@RequestBody Zwjl zwjl);
    @PostMapping("deleteResume")
    void deleteResume(@RequestParam("ids")String ids);
    @GetMapping("findZwjlById")
    Zwjl findZwjlById(@RequestParam("id") Integer id);
    @PostMapping("updateZwjl")
    void updateZwjl(Zwjl zwjl);

    @GetMapping("querygsbyid")
    Gsyh querygsbyid(@RequestParam("gsid")Integer gsid);
}
