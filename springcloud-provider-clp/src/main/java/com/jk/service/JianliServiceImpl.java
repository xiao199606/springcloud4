/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: JianliServiceImpl
 * Author:   clp
 * Date:     2019/9/19 11:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.dao.JianliMapper;
import com.jk.model.ClpModel.Jianli;
import com.jk.util.PageRowsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author clp
 * @create 2019/9/19
 * @since 1.0.0
 */
@Service
public class JianliServiceImpl implements JianliService {

    @Autowired
    private JianliMapper jianliMapper;

    @Override
    public Map queryJianli(PageRowsUtil pageRowsUtil) {

        int sta=(pageRowsUtil.getPage()-1)*pageRowsUtil.getRows();
        List<Jianli> list=jianliMapper.queryJianli(sta,pageRowsUtil.getRows());
        long count=jianliMapper.queryCount();

        Map map=new HashMap();
        map.put("rows",list);
        map.put("total",count);
        return map;
    }

    @Override
    public void updateYes(Integer id) {
        jianliMapper.updateYes(id);
    }

    @Override
    public void deleteNo(Integer id) {
        jianliMapper.deleteNo(id);
    }
}
