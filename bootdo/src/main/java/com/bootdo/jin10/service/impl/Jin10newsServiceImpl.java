package com.bootdo.jin10.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.jin10.dao.Jin10newsDao;
import com.bootdo.jin10.domain.Jin10newsDO;
import com.bootdo.jin10.service.Jin10newsService;



@Service
public class Jin10newsServiceImpl implements Jin10newsService {
	@Autowired
	private Jin10newsDao jin10newsDao;
	
	@Override
	public Jin10newsDO get(Integer id){
		return jin10newsDao.get(id);
	}
	
	@Override
	public List<Jin10newsDO> list(Map<String, Object> map){
		return jin10newsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return jin10newsDao.count(map);
	}
	
	@Override
	public int save(Jin10newsDO jin10news){
		return jin10newsDao.save(jin10news);
	}
	
	@Override
	public int update(Jin10newsDO jin10news){
		return jin10newsDao.update(jin10news);
	}
	
	@Override
	public int remove(Integer id){
		return jin10newsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return jin10newsDao.batchRemove(ids);
	}
	
}
