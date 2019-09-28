package com.entor.service;

import java.util.List;

import com.entor.entity.Order;

public interface OrderService extends BaseService<Order>{

	
	public List<Order> queryByUid(Class<?> cls,int uid);
}
