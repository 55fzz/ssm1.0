package com.entor.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.BaseDao;
import com.entor.entity.SP;
import com.entor.service.BaseService;


@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T>{

	@Resource
	private BaseDao<T> baseDao;
	
	@Override
	public T queryById(Class<?> cls, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.queryById(cls, id);
	}

	@Override
	public List<T> queryByPage(Class<?> cls, SP s) {
		// TODO Auto-generated method stub
		return baseDao.queryByPage(cls, s);
	}

	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		baseDao.add(t);
	}

	@Override
	public void deleteById(Class<?> cls, Serializable id) {
		// TODO Auto-generated method stub
		baseDao.deleteById(cls, id);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		baseDao.update(t);
	}

	@Override
	public int getTotals(Class<?> cls) {
		// TODO Auto-generated method stub
		return baseDao.getTotals(cls);
	}

	@Override
	public List<T> queryAll(Class<?> cls) {
		// TODO Auto-generated method stub
		return baseDao.queryAll(cls);
	}

}
