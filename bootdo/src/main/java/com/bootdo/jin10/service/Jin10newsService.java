package com.bootdo.jin10.service;

import com.bootdo.jin10.domain.Jin10newsDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-09-30 13:30:05
 */
public interface Jin10newsService {
	
	Jin10newsDO get(Integer id);
	
	List<Jin10newsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Jin10newsDO jin10news);
	
	int update(Jin10newsDO jin10news);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
