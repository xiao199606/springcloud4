/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: ShenheUserService
 * Author:   clp
 * Date:     2019/9/20 15:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.util.PageRowsUtil;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author clp
 * @create 2019/9/20
 * @since 1.0.0
 */
public interface ShenheUserService {
    Map queryShenheUser(PageRowsUtil pageRowsUtil);

    void updateShenheYes(Integer id);

    void deleteShenheNo(Integer id);
}
