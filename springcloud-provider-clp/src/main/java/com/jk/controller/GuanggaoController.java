/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: GuanggaoController
 * Author:   clp
 * Date:     2019/9/20 9:09
 * Description: 广告审核
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.service.GuanggaoService;
import com.jk.util.PageRowsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈广告审核〉
 *
 * @author clp
 * @create 2019/9/20
 * @since 1.0.0
 */
@Controller
public class GuanggaoController {

     @Autowired
     private GuanggaoService guanggaoService;

     @RequestMapping("queryGuanggao")
    @ResponseBody
    public Map queryGuanggao(@RequestBody PageRowsUtil pageRowsUtil){
         return guanggaoService.queryGuanggao(pageRowsUtil);
     }

    @RequestMapping("updateGgYes")
    @ResponseBody
    public void updateGgYes(Integer id){
        guanggaoService.updateGgYes(id);
    }

    @RequestMapping("deleteGgNo")
    @ResponseBody
    public void deleteGgNo(Integer id){
        guanggaoService.deleteGgNo(id);
    }



}
