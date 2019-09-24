/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: YuangongJianliController
 * Author:   clp
 * Date:     2019/9/20 19:40
 * Description: 员工简历管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.model.User;
import com.jk.service.YuangongJianliService;
import com.jk.util.PageRowsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈员工简历管理〉
 *
 * @author clp
 * @create 2019/9/20
 * @since 1.0.0
 */
@Controller
public class YuangongJianliController {

    @Autowired
    private YuangongJianliService yuangongJianliService;


    @RequestMapping("queryYuangongJianli")
    @ResponseBody
    public Map queryYuangongJianli(@RequestBody PageRowsUtil pageRowsUtil){
        return yuangongJianliService.queryYuangongJianli(pageRowsUtil);
    }


    @RequestMapping("deleteJianli")
    @ResponseBody
    public void deleteJianli(Integer id){
        yuangongJianliService.deletegsyhjianli(id);
    }

}
