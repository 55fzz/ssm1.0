package com.entor.dao;

import java.util.List;

import com.entor.entity.Propertyvalue;

public interface PropertyvalueDao extends BaseDao<Propertyvalue>{
	
	
	public List<Propertyvalue> queryByPid(Class<?> cls,int pid);
}
