package com.jk.dao;

import com.jk.model.*;
import org.apache.ibatis.annotations.Options;

import java.util.HashMap;
import java.util.List;

public interface XxfDao {

    List<Tree> getTreeAll();

    Integer queryResumeCount();

    List<Zwjl> queryZwjl(HashMap<String, Object> hashMap);

    List<Leib> queryleib();
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addgsZwjl(Zwjl zwjl);

    void deleteResume(String[] arrIds);

    Zwjl findZwjlById(Integer id);

    void updateZwjl(Zwjl zwjl);

    Gsyh querygsbyid(Integer gsid);
}
