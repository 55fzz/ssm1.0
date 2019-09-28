package com.entor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entor.dao.ReviewDao;
import com.entor.entity.Review;


@Repository("reviewDao")
public class ReviewDaoImpl extends BaseDaoImpl<Review> implements ReviewDao{

	@Override
	public int getReviewCount(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(cls.getSimpleName()+".getReviewCount", pid);
	}

	@Override
	public List<Review> queryByPid(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(cls.getSimpleName()+".queryByPid",pid);
	}

}
