package com.jk.service;

import com.jk.util.PageRowsUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ClpServiceApi {

    @RequestMapping(value = "queryJianli",method = RequestMethod.GET)
    Map queryJianli(@RequestBody PageRowsUtil pageRowsUtil) ;

    @RequestMapping(value = "updateYes",method = RequestMethod.POST)
    void updateYes(@RequestParam("id") Integer id);

    @RequestMapping(value = "deleteNo",method = RequestMethod.POST)
    void deleteNo(@RequestParam("id") Integer id);

    @RequestMapping(value = "queryGsyh",method = RequestMethod.GET)
    Map queryGsyh(@RequestBody PageRowsUtil pageRowsUtil) ;


    @RequestMapping(value = "updateGsYes",method = RequestMethod.POST)
    void updateGsYes(@RequestParam("id")Integer id);

    @RequestMapping(value = "deleteGsNo",method = RequestMethod.POST)
    void deleteGsNo(@RequestParam("id")Integer id);


    @RequestMapping(value = "queryGuanggao",method = RequestMethod.GET)
    Map queryGuanggao(@RequestBody PageRowsUtil pageRowsUtil);

    @RequestMapping(value = "updateGgYes",method = RequestMethod.POST)
    void updateGgYes(@RequestParam("id")Integer id);

    @RequestMapping(value = "deleteGgNo",method = RequestMethod.POST)
    void deleteGgNo(@RequestParam("id")Integer id);

    @RequestMapping(value = "queryZhiwei",method = RequestMethod.GET)
    Map queryZhiwei(@RequestBody PageRowsUtil pageRowsUtil);

    @RequestMapping(value = "updateZhiweiYes",method = RequestMethod.POST)
    void updateZhiweiYes(@RequestParam("id")Integer id);

    @RequestMapping(value = "updateZhiweiNo",method = RequestMethod.POST)
    void updateZhiweiNo(@RequestParam("id")Integer id);

    @RequestMapping(value = "deleteZhiweiNo",method = RequestMethod.POST)
    void deleteZhiweiNo(@RequestParam("id")Integer id);


}
