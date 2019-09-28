package com.entor.dao;

import java.util.List;
import java.util.Map;

import com.entor.entity.Property;
import com.entor.entity.SP;

public interface PropertyDao extends BaseDao<Property>{

	
	public List<Property> queryByPage(Class<?> cls,Map<String,Object> map);
	
	public int getTotals(Class<?> cls,int cid);
	
	public List<Property> queryByCid(Class<?> cls,int cid);
	
}
