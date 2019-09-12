package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="SERVICE-PROVIDER-HB")
public interface HbService extends HbServiceApi{

}
