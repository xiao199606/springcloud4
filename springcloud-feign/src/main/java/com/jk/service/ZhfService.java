package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="SERVICE-PROVIDER-ZHF")
public interface ZhfService extends ZhfServiceApi{

}
