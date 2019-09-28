package com.entor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyvalueDao;
import com.entor.entity.Propertyvalue;


@Repository("propertyvalueDao")
public class PropertyvalueDaoImpl extends BaseDaoImpl<Propertyvalue> implements PropertyvalueDao{

	
	@Override
	public List<Propertyvalue> queryByPid(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(cls.getSimpleName()+".queryByPid", pid);
	}

}
