package com.jk.dao;


import com.jk.model.Gsyh;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GsyhMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gsyh record);

    int insertSelective(Gsyh record);

    Gsyh selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gsyh record);

    int updateByPrimaryKey(Gsyh record);

    List<Gsyh> queryGsyh(@Param("sta") int sta,@Param("rows") Integer rows);

    long queryGsCount();

    void updateGsYes(@Param("id")Integer id);

    void deleteGsNo(@Param("id")Integer id);
}