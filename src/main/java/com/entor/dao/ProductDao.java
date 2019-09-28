package com.entor.dao;

import java.util.List;
import java.util.Map;

import com.entor.entity.Product;
import com.entor.entity.SP;

public interface ProductDao extends BaseDao<Product>{
	
	
	public List<Product> queryByPage(Class<?> cls,Map<String, Object> map);
	
	public int getTotals(Class<?> cls,int cid);
	
	public List<Product> queryByCid(Class<?> cls,int cid);
	
	public List<Product> queryByKeyword(Class<?> cls,Map<String,Object> map);
	
	public int getTotalsByKeyword(Class<?> cls,String keyword);
	
	public int getCidById(Class<?> cls,int id) ;
}
