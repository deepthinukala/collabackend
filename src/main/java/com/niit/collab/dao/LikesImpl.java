/*package com.niit.collab.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Forum;
import com.niit.collab.model.ForumComment;
import com.niit.collab.model.Likes;

@Repository(value="likesDAO")
public class LikesImpl implements LikesDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public LikesImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Likes likes) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(likes);
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Likes get(int id) {
		String hql = "from Likes where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Likes>list= query.list();
		
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
	public Long likeget(int blogid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Likes.class);
		c.add(Restrictions.eq("blogid", bid));
		List<Likes> list=c.list();
		return list;
		long row = 0;
		
		String hql =  " select count(*)from LIKES where blogid="+blogid;
		String hql = "select count(*) from Likes where blogid= "+ "'"+ blogid+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		for(Iterator it=query.iterate();it.hasNext();)
		  {
		  row = (Long) it.next();
		   System.out.print("Count: " + row);
			
		  }
		return row;
		
	
	}

	
	@Transactional
	public long likes(int uid) {
		 Criteria c=sessionFactory.getCurrentSession().createCriteria(Likes.class);
		  c.add(Restrictions.eq("userid", uid));
		  c.add(Restrictions.eq("status","C"));
		  c.setProjection(Projections.count("uid"));
		  long count=(Long) c.uniqueResult();
		  return count;
		 }

	@Transactional
	public double total(int uid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Likes.class);
		  c.add(Restrictions.eq("userid", uid));
		  c.add(Restrictions.eq("status","C"));
		  c.setProjection(Projections.sum("quantity"));
		  double l= (Double)c.uniqueResult();
		  return l;
	}

	@Transactional
	public Likes getUser(int uid) {
		 String hql="from Likes where userid= "+uid;
		  @SuppressWarnings("rawtypes")
		  Query query = sessionFactory.getCurrentSession().createQuery(hql);
		  List<Likes>listproduct=query.list();

		  if(listproduct.isEmpty())
		  {
		   
		   return null;
		  }
		  else
		  {
		   System.out.println("user");
		   return listproduct.get(0);
		  }
		
	}

	
	
	
	
	
	
	
	
	
	
	
	public List<Likes> list(int bid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Likes.class);
		c.add(Restrictions.eq("blogid", bid));
		List<Likes> list=c.list();
		return list;
	}

	

	}
	
	


*/