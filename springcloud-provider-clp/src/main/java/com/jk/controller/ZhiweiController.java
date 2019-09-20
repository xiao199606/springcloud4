/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: ZhiweiController
 * Author:   clp
 * Date:     2019/9/20 11:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.service.GuanggaoService;
import com.jk.service.ZhiweiService;
import com.jk.util.PageRowsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author clp
 * @create 2019/9/20
 * @since 1.0.0
 */
@Controller
public class ZhiweiController {

    @Autowired
    private ZhiweiService zhiweiService;

    @RequestMapping("queryZhiwei")
    @ResponseBody
    public Map queryZhiwei(@RequestBody PageRowsUtil pageRowsUtil){
        return zhiweiService.queryZhiwei(pageRowsUtil);
    }

    @RequestMapping("updateZhiweiYes")
    @ResponseBody
    public void updateZhiweiYes(Integer id){
        zhiweiService.updateZhiweiYes(id);
    }

    @RequestMapping("updateZhiweiNo")
    @ResponseBody
    public void updateZhiweiNo(Integer id){
        zhiweiService.updateZhiweiNo(id);
    }




    @RequestMapping("deleteZhiweiNo")
    @ResponseBody
    public void deleteZhiweiNo(Integer id){
        zhiweiService.deleteZhiweiNo(id);
    }


}
