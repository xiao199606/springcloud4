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

<<<<<<< HEAD
import lombok.Data;
=======
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
>>>>>>> 9f27dcb8c3222979b42c9ed9a244c7cf3e68cb64

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
public class Zwjl {
    private Integer id;
    private String zhiw;
    private String leib;
    private String diq;
    private Integer rensh;
    private String yex;
    private String jiesh;
    private String zhuany;
    private String xuel;
    private String jingy;
    private Integer sex;
    private Integer minage;
    private Integer maxage;
    private String lianxr;
    private String lianxtel;
    private String email;
    private Date fdate;

    //一下是联查所需字段
    private String gongsmc;//公司名称
    private String gongsxz;//公司性质

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date fdate;
}
