package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="SERVICE-PROVIDER-CLP")
public interface ClpService extends ClpServiceApi{

}
