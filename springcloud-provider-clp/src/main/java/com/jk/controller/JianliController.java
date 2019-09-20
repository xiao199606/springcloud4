/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: JianliController
 * Author:   clp
 * Date:     2019/9/19 11:04
 * Description: 审核简历
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.service.JianliService;
import com.jk.util.PageRowsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈审核简历〉
 *
 * @author clp
 * @create 2019/9/19
 * @since 1.0.0
 */
@Controller
public class JianliController {

    @Autowired
    private JianliService jianliService;




    @RequestMapping("queryJianli")
    @ResponseBody
    public Map queryJianli(@RequestBody PageRowsUtil pageRowsUtil){
        return jianliService.queryJianli(pageRowsUtil);
    }

    @RequestMapping("updateYes")
    @ResponseBody
    public void updateYes(Integer id){
         jianliService.updateYes(id);
    }

    @RequestMapping("deleteNo")
    @ResponseBody
    public void deleteNo(Integer id){
         jianliService.deleteNo(id);
    }





}
