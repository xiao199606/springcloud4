package com.jk.dao;


import com.jk.model.ClpModel.Jianli;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JianliMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jianli record);

    int insertSelective(Jianli record);

    Jianli selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jianli record);

    int updateByPrimaryKey(Jianli record);

    List<Jianli> queryJianli(@Param("sta") int sta,@Param("rows") Integer rows);

    long queryCount();

    void updateYes(@Param("id")Integer id);

    void deleteNo(@Param("id")Integer id);
}