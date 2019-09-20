/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: ZhiweiServiceImpl
 * Author:   clp
 * Date:     2019/9/20 11:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.dao.ZwjlMapper;
import com.jk.model.Guanggao;
import com.jk.model.Zwjl;
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
 * @create 2019/9/20
 * @since 1.0.0
 */
@Service
public class ZhiweiServiceImpl implements ZhiweiService{

    @Autowired
    private ZwjlMapper zwjlMapper;

    @Override
    public Map queryZhiwei(PageRowsUtil pageRowsUtil) {
        int sta=(pageRowsUtil.getPage()-1)*pageRowsUtil.getRows();
        List<Zwjl> list=zwjlMapper.queryZhiwei(sta,pageRowsUtil.getRows());
        long count=zwjlMapper.queryCount();

        Map map=new HashMap();
        map.put("rows",list);
        map.put("total",count);
        return map;
    }

    @Override
    public void updateZhiweiYes(Integer id) {
        zwjlMapper.updateZhiweiYes(id);
    }

    @Override
    public void deleteZhiweiNo(Integer id) {
        zwjlMapper.deleteZhiweiNo(id);
    }

    @Override
    public void updateZhiweiNo(Integer id) {
        zwjlMapper.updateZhiweiNo(id);
    }
}
