package com.niit.collab.dao;

import java.util.List;

import com.niit.collab.model.User;

public interface UserDAO {
	public boolean saveOrUpdate(User user);
	public boolean delete(User user);
	public List<User>list();
	public User get(int id);
	public List<User> getuser(int id);
	public User logout(int id);
	public User authuser(String username,String password);
	/*public User oneuser(int id);*/
	public User profileof(String username);
	public List<User> nonfriends(int id);
}
