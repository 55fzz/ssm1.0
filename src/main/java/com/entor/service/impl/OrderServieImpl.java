package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.OrderDao;
import com.entor.entity.Order;
import com.entor.service.OrderService;

@Service("orderService")
public class OrderServieImpl extends BaseServiceImpl<Order> implements OrderService{

	@Resource
	private OrderDao orderDao;
	
	@Override
	public List<Order> queryByUid(Class<?> cls, int uid) {
		// TODO Auto-generated method stub
		return orderDao.queryByUid(cls, uid);
	}

}
