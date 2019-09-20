/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: ZhiweiService
 * Author:   clp
 * Date:     2019/9/20 11:47
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
public interface ZhiweiService {
    Map queryZhiwei(PageRowsUtil pageRowsUtil);

    void updateZhiweiYes(Integer id);

    void deleteZhiweiNo(Integer id);

    void updateZhiweiNo(Integer id);
}
