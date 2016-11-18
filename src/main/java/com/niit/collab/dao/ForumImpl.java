package com.niit.collab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Forum;

@Repository(value="forumDAO")
public class ForumImpl implements ForumDAO {
	private static final Logger log = LoggerFactory.getLogger(ForumImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	public ForumImpl (SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	/*Used for creating or updating Forum*/
	@Transactional
	public void saveOrUpdate(Forum forum) {
		sessionFactory.getCurrentSession().save(forum);
	}

	/*Retrieves all Forums*/
	@Transactional
	public List<Forum> getForums() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Forum.class);
		List<Forum> list=c.list();
		return list;
	}

	/*Delete single Forum object*/
	@Transactional
	public void deleteForum(Forum forum) {
		sessionFactory.getCurrentSession().delete(forum);
	}

	/*Fetch single forum object based on forumid*/
	@Transactional
	public Forum getForum(int forumid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Forum.class);
		c.add(Restrictions.eq("fid", forumid));
		Forum forum=(Forum) c.uniqueResult();
		return forum;
	}

	@Transactional
	public List<Forum> getIndividualForum(int forumid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Forum.class);
		c.add(Restrictions.eq("fid", forumid));
		List<Forum> list=c.list();
		return list;
	}

}
