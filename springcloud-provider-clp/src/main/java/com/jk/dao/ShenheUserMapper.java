package com.jk.dao;

import com.jk.model.ShenheUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShenheUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShenheUser record);

    int insertSelective(ShenheUser record);

    ShenheUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShenheUser record);

    int updateByPrimaryKey(ShenheUser record);

    List<ShenheUser> queryShenheUser(@Param("sta") int sta, @Param("rows") Integer rows);

    long queryCount();

    void updateShenheYes(@Param("id")Integer id);

    void deleteShenheNo(@Param("id")Integer id);
}