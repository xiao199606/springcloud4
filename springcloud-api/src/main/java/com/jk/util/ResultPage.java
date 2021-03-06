/** 
 * <pre>项目名称:yasyui 
 * 文件名称:ResultPage.java 
 * 包名:com.jk.zc.utils 
 * 创建日期:2019年5月17日下午8:13:02 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.util;

import java.io.Serializable;

/**
 * <pre>项目名称：
 * 类名称：ResultPage    
 * 类描述：    
 * 创建人：黄斌
 * 创建时间：2019年9月18日 下午8:13:02
 * 修改人：黄斌
 * 修改时间：2019年9月18日 下午8:13:02
 * 修改备注：       
 * @version </pre>   
 */
public class ResultPage implements Serializable {
   private Integer total;
   private Object rows;
   private Integer pageNumber;//当前页
   private Integer pageSize;//每页条数
   private String name;//条查名称
   private Integer gsyhid;

	public Integer getGsyhid() {
		return gsyhid;
	}

	public void setGsyhid(Integer gsyhid) {
		this.gsyhid = gsyhid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "ResultPage{" +
				"total=" + total +
				", rows=" + rows +
				", pageNumber=" + pageNumber +
				", pageSize=" + pageSize +
				'}';
	}
}
