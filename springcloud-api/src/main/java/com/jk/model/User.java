/**
 * Copyright (C), 2019-2019, 金科
 * FileName: User
 * Author:  黄斌
 * Date:     2019/9/17 15:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 斌
 * @create 2019/9/17
 * @since 1.0.0
 */
@Data
public class User implements Serializable {

     private static final long serialVersionUID = -2657228821938837583L;
     private Integer id;
     private String username;
     private String password;
}
