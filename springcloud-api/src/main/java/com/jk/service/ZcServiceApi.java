package com.jk.service;

import com.jk.model.zcModel.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ZcServiceApi {
    @GetMapping(value="zcTest")
    Map test();

    @GetMapping(value="zcRegister")
    void zcRegister(@RequestBody UserModel userModel);
}
