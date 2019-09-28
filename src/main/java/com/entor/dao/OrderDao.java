package com.entor.dao;

import java.io.Serializable;
import java.util.List;

import com.entor.entity.Order;

public interface OrderDao extends BaseDao<Order>{

	public List<Order> queryByUid(Class<?> cls,int uid);
}
