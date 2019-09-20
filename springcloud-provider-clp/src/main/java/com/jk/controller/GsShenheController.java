/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: GsShenheController
 * Author:   clp
 * Date:     2019/9/19 19:56
 * Description: 公司审核
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.service.GsShenheService;
import com.jk.util.PageRowsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈公司审核〉
 *
 * @author clp
 * @create 2019/9/19
 * @since 1.0.0
 */
@Controller
public class GsShenheController {

    @Autowired
    private GsShenheService gsShenheService;

    //公司审核
    @RequestMapping("queryGsyh")
    @ResponseBody
    public Map queryGsyh(@RequestBody PageRowsUtil pageRowsUtil){
        return gsShenheService.queryGsyh(pageRowsUtil);
    }

    @RequestMapping("updateGsYes")
    @ResponseBody
    public void updateGsYes(Integer id){
        gsShenheService.updateGsYes(id);
    }

    @RequestMapping("deleteGsNo")
    @ResponseBody
    public void deleteGsNo(Integer id){
        gsShenheService.deleteGsNo(id);
    }

}
