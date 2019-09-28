package com.entor.service;

import java.util.List;

import com.entor.entity.Review;

public interface ReviewService extends BaseService<Review>{

	
	public int getReviewCount(Class<?> cls,int pid);
	
	public List<Review> queryByPid(Class<?> cls,int pid);
}
