package com.niit.collab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.ForumComment;
import com.niit.collab.model.User;

@Repository(value="forumCommentDAO")
public class ForumCommentImpl implements ForumCommentDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	public ForumCommentImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(ForumComment forumcomment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forumcomment);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public boolean delete(ForumComment forumcomment) {
		try {
			sessionFactory.getCurrentSession().delete(forumcomment);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<ForumComment> list(int fid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(ForumComment.class);
		c.add(Restrictions.eq("forumid", fid));
		List<ForumComment> list=c.list();
		return list;
	}

	@Transactional
	public ForumComment get(int id) {
		String hql = "from ForumComment where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumComment>list= query.list();
		
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

