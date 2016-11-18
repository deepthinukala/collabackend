package com.niit.collab.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Blog;

@Repository
public class BlogImpl implements BlogDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*public BlogImpl (SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	*/
	/*Used for creating or updating Blog*/
	@Transactional
	public void saveorUpdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	/*Retrieves all Blogs*/
	@SuppressWarnings("deprecation")
	@Transactional
	public List<Blog> getBlogs() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Blog.class);
		@SuppressWarnings("unchecked")
		List<Blog> list=c.list();
		return list;
	}

	/*Delete single Blog object*/
	@Transactional
	public void deleteBlog(Blog blog) {
		sessionFactory.getCurrentSession().delete(blog);
	}

	/*Fetch single blog object based on blogid*/
	@SuppressWarnings("deprecation")
	@Transactional
	public Blog getBlog(int blogid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Blog.class);
		c.add(Restrictions.eq("bid", blogid));
		Blog blog=(Blog) c.uniqueResult();
		return blog;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<Blog> getIndividualForum(int blogid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Blog.class);
		c.add(Restrictions.eq("bid", blogid));
		List<Blog> list=c.list();
		return list;
	}

}


