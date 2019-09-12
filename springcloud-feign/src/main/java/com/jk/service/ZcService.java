package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="SERVICE-PROVIDER-ZC")
public interface ZcService extends ZcServiceApi{

}
