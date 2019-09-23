/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: ShenheUserController
 * Author:   clp
 * Date:     2019/9/20 15:28
 * Description: 公司人员审核
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.service.GuanggaoService;
import com.jk.service.ShenheUserService;
import com.jk.util.PageRowsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈公司人员审核〉
 *
 * @author clp
 * @create 2019/9/20
 * @since 1.0.0
 */
@Controller
public class ShenheUserController {


    @Autowired
    private ShenheUserService shenheUserService;

    @RequestMapping("queryShenheUser")
    @ResponseBody
    public Map queryShenheUser(@RequestBody PageRowsUtil pageRowsUtil){
        return shenheUserService.queryShenheUser(pageRowsUtil);
    }

    @RequestMapping("updateShenheYes")
    @ResponseBody
    public void updateShenheYes(Integer id){
        shenheUserService.updateShenheYes(id);
    }

    @RequestMapping("deleteShenheNo")
    @ResponseBody
    public void deleteShenheNo(Integer id){
        shenheUserService.deleteShenheNo(id);
    }



}
