package com.jk.dao;

import com.jk.model.Zwjl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZwjlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zwjl record);

    int insertSelective(Zwjl record);

    Zwjl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zwjl record);

    int updateByPrimaryKey(Zwjl record);

    List<Zwjl> queryZhiwei(@Param("sta") int sta, @Param("rows") Integer rows);

    long queryCount();

    void updateZhiweiYes(@Param("id") Integer id);

    void deleteZhiweiNo(@Param("id") Integer id);

    void updateZhiweiNo(@Param("id") Integer id);
}