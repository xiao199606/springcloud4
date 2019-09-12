package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="SERVICE-PROVIDER-XXF")
public interface XxfService extends XxfServiceApi{

}
