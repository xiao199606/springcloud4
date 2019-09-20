package com.jk.dao;

import com.jk.model.Guanggao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuanggaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Guanggao record);

    int insertSelective(Guanggao record);

    Guanggao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Guanggao record);

    int updateByPrimaryKey(Guanggao record);

    List<Guanggao> queryGuanggao(@Param("sta") int sta, @Param("rows") Integer rows);

    long queryCount();

    void deleteGgNo(@Param("id")Integer id);

    void updateGgYes(@Param("id")Integer id);
}