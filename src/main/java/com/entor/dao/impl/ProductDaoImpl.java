package com.entor.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductDao;
import com.entor.entity.Product;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

	@Override
	public int getTotals(Class<?> cls, int cid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(cls.getSimpleName()+".getTotals",cid);
	}

	@Override
	public List<Product> queryByPage(Class<?> cls, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(cls.getSimpleName()+".queryByPage",map);
	}

	@Override
	public List<Product> queryByCid(Class<?> cls, int cid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(cls.getSimpleName()+".queryByCid",cid);
	}


	@Override
	public List<Product> queryByKeyword(Class<?> cls, Map<String,Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(cls.getSimpleName()+".queryByKeyword", map);
	}

	@Override
	public int getTotalsByKeyword(Class<?> cls, String keyword) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(cls.getSimpleName()+".getTotalsByKeyword",keyword);
	}

	@Override
	public int getCidById(Class<?> cls, int id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(cls.getSimpleName()+".getCidById",id);
	}

}
