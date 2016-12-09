package com.niit.collab.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Blog;

@Repository(value="blogDAO")
public class BlogImpl implements BlogDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	public BlogImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
@Transactional
public boolean saveorUpdate(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			System.out.println("save");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<Blog> getBlogs() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Blog.class);
		List<Blog> list=c.list();
		return list;
	}
	@Transactional
	public Blog getBlog(int blogid) {
		String hql = "from Blog where blogid= "+ "'"+ blogid+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<Blog> getIndividualForum(int blogid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Blog.class);
		c.add(Restrictions.eq("blogid", blogid));
		List<Blog> list=c.list();
		return list;
	}
	
	
	

}


