package com.jk.service;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public interface ZcServiceApi {
    @GetMapping(value="zcTest")
    Map test();
}
