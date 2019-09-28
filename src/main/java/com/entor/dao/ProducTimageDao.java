package com.entor.dao;

import java.util.List;

import com.entor.entity.ProducTimage;

public interface ProducTimageDao extends BaseDao<ProducTimage> {

	
	public ProducTimage queryByPidOne(Class<?> cls,int pid);
	
	public List<ProducTimage> querySingleByPid(Class<?> cls,int pid);
	
	public List<ProducTimage> queryDetailByPid(Class<?> cls,int pid);
}
