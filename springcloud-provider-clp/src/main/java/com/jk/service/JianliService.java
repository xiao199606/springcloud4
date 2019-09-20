/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: JianliService
 * Author:   clp
 * Date:     2019/9/19 11:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.dao.JianliMapper;
import com.jk.util.PageRowsUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author clp
 * @create 2019/9/19
 * @since 1.0.0
 */

public interface JianliService {
     Map queryJianli(PageRowsUtil pageRowsUtil) ;


     void updateYes(Integer id);

     void deleteNo(Integer id);
}
