package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.PropertyDao;
import com.entor.dao.PropertyvalueDao;
import com.entor.entity.Propertyvalue;
import com.entor.service.PropertyvalueService;


@Service("propertyvalueService")
public class PropertyvalueServiceImpl extends BaseServiceImpl<Propertyvalue> implements PropertyvalueService{

	
	@Resource
	private PropertyvalueDao propertyvalueDao;
	
	
	@Override
	public List<Propertyvalue> queryByPid(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return propertyvalueDao.queryByPid(cls, pid);
	}

}
