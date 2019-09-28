package com.entor.dao.impl;

import org.springframework.stereotype.Repository;

import com.entor.dao.UserDao;
import com.entor.entity.User;


@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User login(Class<?> cls,User u) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(cls.getSimpleName()+".login", u);
	}

}
