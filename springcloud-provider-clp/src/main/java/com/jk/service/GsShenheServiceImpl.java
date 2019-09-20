/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: GsShenheServiceImpl
 * Author:   clp
 * Date:     2019/9/19 19:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.dao.GsyhMapper;
import com.jk.model.Gsyh;
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
public class GsShenheServiceImpl implements GsShenheService{

    @Autowired
    private GsyhMapper gsyhMapper;

    @Override
    public Map queryGsyh(PageRowsUtil pageRowsUtil) {
        int sta=(pageRowsUtil.getPage()-1)*pageRowsUtil.getRows();
        List<Gsyh> list=gsyhMapper.queryGsyh(sta,pageRowsUtil.getRows());
        long count=gsyhMapper.queryGsCount();

        Map map=new HashMap();
        map.put("rows",list);
        map.put("total",count);
        return map;
    }

    @Override
    public void updateGsYes(Integer id) {
        gsyhMapper.updateGsYes(id);
    }

    @Override
    public void deleteGsNo(Integer id) {
        gsyhMapper.deleteGsNo(id);
    }
}
