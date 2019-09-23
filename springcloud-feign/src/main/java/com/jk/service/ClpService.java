package com.jk.service;

import com.jk.util.PageRowsUtil;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Map;

@FeignClient(value="SERVICE-PROVIDER-CLP")
public interface ClpService extends ClpServiceApi{


}
