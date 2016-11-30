package com.niit.collab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Blog;
import com.niit.collab.model.Job;
@Repository
public class JobImpl implements JobDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public JobImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(Job job) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			System.out.println("save");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Job getJob(int id) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Blog.class);
		c.add(Restrictions.eq("id", id));
		Job job=(Job) c.uniqueResult();
		return job;
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	public List<Job> getJobs() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Job.class);
		@SuppressWarnings("unchecked")
		List<Job> list=c.list();
		return list;
	}
	
}
