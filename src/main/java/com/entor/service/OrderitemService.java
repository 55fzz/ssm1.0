package com.entor.service;

import java.util.List;

import com.entor.entity.Orderitem;

public interface OrderitemService extends BaseService<Orderitem>{

	
	public List<Orderitem> queryByOid(Class<?> cls,int oid);
	
	public int getSaleCount(Class<?> cls,int pid);
	
	public int getCartTotalItemNumberByUid(Class<?> cls,int uid) ;
	
	public List<Orderitem> queryByUid(Class<?> cls,int uid);
	
	public Orderitem queryByUidAndPid(Orderitem oi);
}
