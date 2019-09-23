/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: GuanggaoServiceImpl
 * Author:   clp
 * Date:     2019/9/20 9:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.dao.GuanggaoMapper;
import com.jk.model.Guanggao;
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
public class GuanggaoServiceImpl implements GuanggaoService{

    @Autowired
    private GuanggaoMapper guanggaoMapper;

    @Override
    public Map queryGuanggao(PageRowsUtil pageRowsUtil) {
        int sta=(pageRowsUtil.getPage()-1)*pageRowsUtil.getRows();
        List<Guanggao> list=guanggaoMapper.queryGuanggao(sta,pageRowsUtil.getRows());
        long count=guanggaoMapper.queryCount();

        Map map=new HashMap();
        map.put("rows",list);
        map.put("total",count);
        return map;
    }

    @Override
    public void updateGgYes(Integer id) {
        guanggaoMapper.updateGgYes(id);
    }

    @Override
    public void deleteGgNo(Integer id) {
        guanggaoMapper.deleteGgNo(id);
    }
}
