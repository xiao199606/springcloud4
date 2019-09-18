package com.jk.service;

import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface HbServiceApi {

    @GetMapping(value="test")
     Map test();

    @GetMapping(value="login")
    User login(@RequestParam("username") String username);

    @RequestMapping("getAllTree")
    List<Tree> getTreeAll();
}
