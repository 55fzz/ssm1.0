package com.entor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProducTimageDao;
import com.entor.entity.ProducTimage;


@Repository("producTimageDao")
public class ProducTimageDaoImpl extends BaseDaoImpl<ProducTimage> implements ProducTimageDao{

	@Override
	public ProducTimage queryByPidOne(Class<?> cls,int pid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(cls.getSimpleName()+".queryByPidOne", pid);
	}


	@Override
	public List<ProducTimage> querySingleByPid(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(cls.getSimpleName()+".querySingleByPid", pid);
	}

	@Override
	public List<ProducTimage> queryDetailByPid(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(cls.getSimpleName()+".queryDetailByPid", pid);
	}

}
