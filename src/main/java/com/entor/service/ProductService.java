package com.entor.service;

import java.util.List;
import java.util.Map;

import com.entor.entity.Product;

public interface ProductService extends BaseService<Product>{

	
	public int getTotals(Class<?> cls,int cid);
	
	public List<Product> queryByPage(Class<?> cls,Map<String, Object> map);
	
	public List<Product> queryByCid(Class<?> cls,int cid);
	
	public List<Product> queryByKeyword(Class<?> cls,Map<String,Object> map);
	
	public int getTotalsByKeyword(Class<?> cls,String keyword);
	
	public int getCidById(Class<?> cls,int id) ;
	
}
