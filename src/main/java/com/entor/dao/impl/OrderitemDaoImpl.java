package com.entor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entor.dao.OrderitemDao;
import com.entor.entity.Orderitem;

@Repository("orderitemDao")
public class OrderitemDaoImpl extends BaseDaoImpl<Orderitem> implements OrderitemDao{


	@Override
	public List<Orderitem> queryByOid(Class<?> cls, int oid) {
		return getSqlSession().selectList(cls.getSimpleName()+".queryByPage", oid);
	}

	@Override
	public int getSaleCount(Class<?> cls,int pid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(cls.getSimpleName()+".getSaleCount", pid);
	}

	@Override
	public int getCartTotalItemNumberByUid(Class<?> cls, int uid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(cls.getSimpleName()+".getCartTotalItemNumberByUid", uid);
	}

	@Override
	public List<Orderitem> queryByUid(Class<?> cls, int uid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(cls.getSimpleName()+".queryByUid", uid);
	}

	@Override
	public Orderitem queryByUidAndPid(Orderitem oi) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(oi.getClass().getSimpleName()+".queryByUidAndPid", oi);
	}

}
