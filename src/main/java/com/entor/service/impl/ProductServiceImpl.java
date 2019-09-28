package com.entor.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.ProductDao;
import com.entor.entity.Product;
import com.entor.service.ProductService;


@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

	
	@Resource
	private ProductDao productDao;
	
	@Override
	public int getTotals(Class<?> cls, int cid) {
		// TODO Auto-generated method stub
		return productDao.getTotals(cls,cid);
	}

	@Override
	public List<Product> queryByPage(Class<?> cls, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return productDao.queryByPage(cls, map);
	}

	@Override
	public List<Product> queryByCid(Class<?> cls, int cid) {
		// TODO Auto-generated method stub
		return productDao.queryByCid(cls, cid);
	}


	@Override
	public List<Product> queryByKeyword(Class<?> cls, Map<String,Object> map) {
		// TODO Auto-generated method stub
		return productDao.queryByKeyword(cls, map);
	}

	@Override
	public int getTotalsByKeyword(Class<?> cls, String keyword) {
		// TODO Auto-generated method stub
		return productDao.getTotalsByKeyword(cls, keyword);
	}

	@Override
	public int getCidById(Class<?> cls, int id) {
		// TODO Auto-generated method stub
		return productDao.getCidById(cls, id);
	}

}
