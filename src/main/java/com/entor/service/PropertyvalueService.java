package com.entor.service;

import java.util.List;

import com.entor.entity.Propertyvalue;

public interface PropertyvalueService extends BaseService<Propertyvalue>{

	public List<Propertyvalue> queryByPid(Class<?> cls,int pid);
}
