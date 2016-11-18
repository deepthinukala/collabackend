package com.niit.collab.dao;

import java.util.List;

import com.niit.collab.model.User;

public interface UserDAO {
	public boolean saveOrUpdate(User user);
	public boolean delete(User user);
	public List<User>list();
	public User get(int id);
	
}
