package com.entor.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.PropertyDao;
import com.entor.entity.Property;
import com.entor.service.PropertyService;


@Service("propertyService")
public class PropertyServiceImpl extends BaseServiceImpl<Property> implements PropertyService{

	
	@Resource
	private PropertyDao propertyDao;
	
	@Override
	public List<Property> queryByPage(Class<?> cls, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return propertyDao.queryByPage(cls, map);
	}

	@Override
	public int getTotals(Class<?> cls, int cid) {
		// TODO Auto-generated method stub
		return propertyDao.getTotals(cls, cid);
	}

	@Override
	public List<Property> queryByCid(Class<?> cls, int cid) {
		// TODO Auto-generated method stub
		return propertyDao.queryByCid(cls, cid);
	}

}
