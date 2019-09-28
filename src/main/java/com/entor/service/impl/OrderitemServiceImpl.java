package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.OrderitemDao;
import com.entor.entity.Orderitem;
import com.entor.service.OrderitemService;


@Service("orderitemService")
public class OrderitemServiceImpl extends BaseServiceImpl<Orderitem> implements OrderitemService{

	@Resource
	private OrderitemDao orderitemDao;
	
	@Override
	public List<Orderitem> queryByOid(Class<?> cls, int oid) {
		// TODO Auto-generated method stub
		return orderitemDao.queryByOid(cls, oid);
	}

	@Override
	public int getSaleCount(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return orderitemDao.getSaleCount(cls, pid);
	}

	@Override
	public int getCartTotalItemNumberByUid(Class<?> cls, int uid) {
		// TODO Auto-generated method stub
		return orderitemDao.getCartTotalItemNumberByUid(cls, uid);
	}

	@Override
	public List<Orderitem> queryByUid(Class<?> cls, int uid) {
		// TODO Auto-generated method stub
		return orderitemDao.queryByUid(cls, uid);
	}

	@Override
	public Orderitem queryByUidAndPid(Orderitem oi) {
		// TODO Auto-generated method stub
		return orderitemDao.queryByUidAndPid(oi);
	}

	
	
}
