package com.entor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.UserDao;
import com.entor.entity.User;
import com.entor.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource
	private UserDao userDao;
	
	@Override
	public User login(Class<?> cls, User u) {
		// TODO Auto-generated method stub
		return userDao.login(cls, u);
	}

}
