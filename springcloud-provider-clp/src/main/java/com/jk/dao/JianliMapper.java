package com.jk.dao;


import com.jk.model.JianLi;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JianliMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JianLi record);

    int insertSelective(JianLi record);

    JianLi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JianLi record);

    int updateByPrimaryKey(JianLi record);

    List<JianLi> queryJianli(@Param("sta") int sta,@Param("rows") Integer rows);

    long queryCount();

    void updateYes(@Param("id")Integer id);

    void deleteNo(@Param("id")Integer id);

    List queryYuangongJianli(@Param("sta")int sta,@Param("rows") Integer rows);

    long queryYuangongJianliCount();
}