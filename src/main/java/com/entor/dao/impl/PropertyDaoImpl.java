package com.entor.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyDao;
import com.entor.entity.Property;
import com.entor.entity.SP;


@Repository("propertyDao")
public class PropertyDaoImpl extends BaseDaoImpl<Property> implements PropertyDao{

	@Override
	public List<Property> queryByPage(Class<?> cls,Map<String, Object> map) {
		
		return getSqlSession().selectList(cls.getSimpleName()+".queryByPage", map);
	}

	@Override
	public int getTotals(Class<?> cls, int cid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(cls.getSimpleName()+".getTotals",cid);
	}

	
	
}
