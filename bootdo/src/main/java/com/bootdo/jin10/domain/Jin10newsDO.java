package com.bootdo.jin10.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-09-30 13:30:05
 */
public class Jin10newsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String newtitle;
	//
	private Date datetime;
	//
	private String newstime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setNewtitle(String newtitle) {
		this.newtitle = newtitle;
	}
	/**
	 * 获取：
	 */
	public String getNewtitle() {
		return newtitle;
	}
	/**
	 * 设置：
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	/**
	 * 获取：
	 */
	public Date getDatetime() {
		return datetime;
	}
	/**
	 * 设置：
	 */
	public void setNewstime(String newstime) {
		this.newstime = newstime;
	}
	/**
	 * 获取：
	 */
	public String getNewstime() {
		return newstime;
	}
}
