package com.niit.collab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.User;

@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
@Repository("value=userDAO")
public class UserImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public UserImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<User> list() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(User.class);
		List<User> list=c.list();
		return list;
	}
	
	@Transactional
	public User get(int id) {
		String hql = "from User where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@Transactional
	public List<User> getuser(int id) {
		String hql = "from User where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list;
		}
	
	}		
	
	
	@Transactional
	public User authuser(String username, String password) {
		String hql="from User where username= "+"'"+username+"'"+"and password= "+"'"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User>list=query.list();
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@Transactional
	public User logout(int id) {
		String hql = "from User where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
}
	


	
	
	
	
	
	
	
	
	
	
	
	

