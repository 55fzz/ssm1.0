package com.entor.service;

import java.util.List;
import java.util.Map;

import com.entor.entity.Property;

public interface PropertyService extends BaseService<Property>{
	
	public List<Property> queryByPage(Class<?> cls,Map<String, Object> map);
	
	public int getTotals(Class<?> cls,int cid);
	
	public List<Property> queryByCid(Class<?> cls,int cid);
}
