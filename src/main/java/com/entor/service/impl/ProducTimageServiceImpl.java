package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.ProducTimageDao;
import com.entor.entity.ProducTimage;
import com.entor.service.ProducTimageService;


@Service("producTimageService")
public class ProducTimageServiceImpl extends BaseServiceImpl<ProducTimage> implements ProducTimageService{

	
	@Resource
	private ProducTimageDao producTimageDao;
	
	@Override
	public ProducTimage queryByPidOne(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return producTimageDao.queryByPidOne(cls, pid);
	}


	@Override
	public List<ProducTimage> querySingleByPid(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return producTimageDao.querySingleByPid(cls, pid);
	}

	@Override
	public List<ProducTimage> queryDetailByPid(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return producTimageDao.queryDetailByPid(cls, pid);
	}

}
