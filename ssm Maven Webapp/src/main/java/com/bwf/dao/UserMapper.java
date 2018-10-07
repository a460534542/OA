package com.bwf.dao;


import com.bwf.entity.User;


public interface UserMapper {
	
	User getUserById(int id);	
	
	void add ( User user );
	
	void delete ( int id );
	
	void update ( User user );

	User getUserByUsernameAndPassword(User user);
	
	
}
