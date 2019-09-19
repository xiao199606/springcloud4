package com.jk.service;

import com.jk.model.Tree;
import com.jk.util.ResultPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface XxfServiceApi {

    @GetMapping("getTreeAll")
    List<Tree> getTreeAll();
    @GetMapping("queryZwjl")
    ResultPage queryZwjl(@RequestBody ResultPage resultPage);
}
