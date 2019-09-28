package com.entor.dao;

import java.util.List;

import com.entor.entity.Orderitem;
import com.entor.entity.SP;

public interface OrderitemDao extends BaseDao<Orderitem>{

	public List<Orderitem> queryByOid(Class<?> cls,int oid);
	
	public int getSaleCount(Class<?> cls,int pid);
	
	public int getCartTotalItemNumberByUid(Class<?> cls,int uid) ;
	
	public List<Orderitem> queryByUid(Class<?> cls,int uid);
	
	public Orderitem queryByUidAndPid(Orderitem oi);
}
