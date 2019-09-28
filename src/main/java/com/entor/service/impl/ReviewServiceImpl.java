package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.ReviewDao;
import com.entor.entity.Review;
import com.entor.service.ReviewService;

@Service("reviewService")
public class ReviewServiceImpl extends BaseServiceImpl<Review> implements ReviewService{

	@Resource
	private ReviewDao reviewdao;
	
	@Override
	public int getReviewCount(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return reviewdao.getReviewCount(cls, pid);
	}

	@Override
	public List<Review> queryByPid(Class<?> cls, int pid) {
		// TODO Auto-generated method stub
		return reviewdao.queryByPid(cls, pid);
	}

}
