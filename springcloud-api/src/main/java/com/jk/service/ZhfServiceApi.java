package com.jk.service;

import com.jk.model.Gryh;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ZhfServiceApi {
    @PostMapping("querygy")
    Gryh querygy(@RequestParam("id")Integer id);
    @PostMapping("toujl")
    void toujl(@RequestParam(value = "gsid",required = true) Integer gsid,@RequestParam(value = "jlid",required = true)Integer jlid);


}
