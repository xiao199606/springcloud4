package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="SERVICE-PROVIDER-LMH")
public interface LmhService extends LmhServiceApi{

}
