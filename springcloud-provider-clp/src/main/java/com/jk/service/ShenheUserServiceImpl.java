/**
 * Copyright (C), 2019, XXX有限公司
 * FileName: ShenheUserServiceImpl
 * Author:   clp
 * Date:     2019/9/20 15:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.dao.ShenheUserMapper;
import com.jk.model.Guanggao;
import com.jk.model.ShenheUser;
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
public class ShenheUserServiceImpl implements ShenheUserService{

    @Autowired
    private ShenheUserMapper shenheUserMapper;



    @Override
    public Map queryShenheUser(PageRowsUtil pageRowsUtil) {
        int sta=(pageRowsUtil.getPage()-1)*pageRowsUtil.getRows();
        List<ShenheUser> list=shenheUserMapper.queryShenheUser(sta,pageRowsUtil.getRows());
        long count=shenheUserMapper.queryCount();

        Map map=new HashMap();
        map.put("rows",list);
        map.put("total",count);
        return map;
    }

    @Override
    public void updateShenheYes(Integer id) {
        shenheUserMapper.updateShenheYes(id);
    }

    @Override
    public void deleteShenheNo(Integer id) {
        shenheUserMapper.deleteShenheNo(id);
    }
}
