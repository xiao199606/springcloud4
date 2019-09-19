/**
 * Copyright (C), 2019-2019, 金科
 * FileName: Zwjl
 * Author:  黄斌
 * Date:     2019/9/19 10:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 斌
 * @create 2019/9/19
 * @since 1.0.0
 */
@Data
@Document(indexName = "work",type = "workaction",shards = 3)
public class Zwjl {
    @Id
    private Integer id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String zhiw;
    private String leib;
    private String diq;
    private Integer rensh;
    private String yex;
    private String jiesh;
    private String zhuany;
    @Field(type = FieldType.Keyword)
    private String xuel;
    @Field(type = FieldType.Keyword)
    private String jingy;
    private Integer sex;
    private Integer minage;
    private Integer maxage;
    private String lianxr;
    private String lianxtel;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date fdate;
    //一下是联查所需字段
    private String gongsmc;//公司名称
    private String gongsxz;//公司性质
    private Integer minsalary;//小薪资区间
    private Integer maxsalary;//大薪资区间
    private String yuangrs;
}
