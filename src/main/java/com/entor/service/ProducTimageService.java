package com.entor.service;

import java.util.List;

import com.entor.entity.ProducTimage;

public interface ProducTimageService extends BaseService<ProducTimage>{

	
	public ProducTimage queryByPidOne(Class<?> cls,int pid);
	
	public List<ProducTimage> querySingleByPid(Class<?> cls,int pid);
	
	public List<ProducTimage> queryDetailByPid(Class<?> cls,int pid);
}
