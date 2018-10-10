package com.bwf.service;

import java.util.List;

import com.bwf.entity.User;

public interface IUserService {

	
	User login( User user );


	List<User> getAllUser();


	List<User> getAllUserByPage(Integer page, Integer pagesize);


	Integer getAllUserCount();


	void delete(Integer id);

	

//	User getMenusByUserId(int userId);
}
