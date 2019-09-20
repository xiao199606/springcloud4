/**
 * Copyright (C), 2019-2019, 金科
 * FileName: JianLi
 * Author:  黄斌
 * Date:     2019/9/18 9:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 斌
 * @create 2019/9/18
 * @since 1.0.0
 */
@Data
public class JianLi {

    private Integer id;
    private String name;
    private Integer sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date birthday;
    private String minz;
    private String huny;
    private String zhengzh;
    private String xuex;
    private String zhuany;
    private String xuel;
    private String gongzjy;
    private String xianjd;
    private String jig;
    private String gangw;
    private String gangwlb;
    private String gongzdq;
    private Integer yuexyq;
    private String qiuzhzht;
    private String jishtch;
    private String gongzjl;
    private String gerjs;
    private String tel;
    private String email;
    private Integer state;

    private Integer zhiding;

    private String tian;

    private String jine;

    private Integer gid;
}
