package com.entor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entor.dao.OrderDao;
import com.entor.entity.Order;


@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao{

	@Override
	public List<Order> queryByUid(Class<?> cls, int uid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(cls.getSimpleName()+".queryByUid", uid);
	}

}
