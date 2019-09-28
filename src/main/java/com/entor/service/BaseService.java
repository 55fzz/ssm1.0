package com.entor.service;

import java.io.Serializable;
import java.util.List;

import com.entor.entity.SP;

public interface BaseService<T> {
	
	
	public T queryById(Class<?> cls,Serializable id);
	
	public List<T> queryByPage(Class<?> cls,SP s);
	
	public void add(T t);
	
	public void deleteById(Class<?> cls,Serializable id);
	
	public void update(T t);
	
	public int getTotals(Class<?> cls);
	
	public List<T> queryAll(Class<?> cls);
}
