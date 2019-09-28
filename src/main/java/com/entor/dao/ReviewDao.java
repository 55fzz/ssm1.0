package com.entor.dao;

import java.util.List;

import com.entor.entity.Review;



public interface ReviewDao extends BaseDao<Review>{

	
	public int getReviewCount(Class<?> cls,int pid);
	
	public List<Review> queryByPid(Class<?> cls,int pid);
}
