package com.entor.service;

import com.entor.entity.User;

public interface UserService extends BaseService<User>{

	public User login(Class<?> cls,User u) ;
}
