package com.entor.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.entor.entity.SP;

public interface BaseDao<T> {

	
	public T queryById(Class<?> cls,Serializable id);
	
	public List<T> queryByPage(Class<?> cls,SP sp);
	
	public void add(T t);
	
	public void deleteById(Class<?> cls,Serializable id);
	
	public void update(T t);
	
	public int getTotals(Class<?> cls);
	
}
