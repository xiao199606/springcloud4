/**
 * Copyright (C), 2019-2019, 金科
 * FileName: tree
 * Author:  黄斌
 * Date:     2019/9/17 16:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 斌
 * @create 2019/9/17
 * @since 1.0.0
 */
@Data
public class Tree implements Serializable {

    private static final long serialVersionUID = -3564411156897423391L;
    private Integer id;
    private String text;
    private String url;
    private Integer pid;
    private Map<String, Object> attributes = new HashMap<String, Object>(); // 添加到节点的自定义属性
    private List<Tree> nodes; //子节点数据
}
