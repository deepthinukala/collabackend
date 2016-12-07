package com.niit.collab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Friend;


@SuppressWarnings("deprecation")
@Repository(value="FriendDAO")
public class FriendImpl implements FriendDAO {
	
	
	Logger log= LoggerFactory.getLogger(FriendImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	public FriendImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		}
/*	@Transactional
	public boolean saveOrUpdate(Friend friend){
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		}
		@Transactional
		public boolean delete(Friend friend){
			try{
				sessionFactory.getCurrentSession().delete(friend);
				return true;
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
	}
		 @Transactional
			public Friend getFriend(int id) {
			 log.debug("sending friend request stared:");
				String hql = "from Friend where id= "+ "'"+ id+"'" ;
				Query query=sessionFactory.getCurrentSession().createQuery(hql);
				List<Friend>list= query.list();
				log.debug("friend request sent");
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
			@SuppressWarnings("unchecked")
			public List<Friend> list() {
				Criteria c=sessionFactory.getCurrentSession().createCriteria(Friend.class);
				List<Friend> list = c.list();
				return list;
			}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Transactional
		public Friend newrequest(int fid,int uid) {
			String hql="from Friend where fid = "+"'"+fid+"'"+"and userid="+"'"+uid+"'";
			Query query =sessionFactory.getCurrentSession().createQuery(hql);
			List<Friend> list=query.list();
			if(list==null){
				return null;
			}else{
				return list.get(0);
			}
		}
		 @SuppressWarnings({ "rawtypes", "unchecked" })
		 @Transactional
		 public Friend newrequest(int id) {
		 	String hql="from Friend where fid = "+"'"+id+"'"+"and status= 'n'";
		 	Query query =sessionFactory.getCurrentSession().createQuery(hql);
		 	List<Friend> list=query.list();
		 	if(list==null){
		 		return null;
		 	}else{
		 		return list.get(0);
		 	}
		 }

		@Transactional
		public List<Friend> getfriendlist(int uid) {
			String hql="from Friend where userid= "+uid;
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Friend> list = query.list();
			return list;
		}
		@Transactional
		public Friend acceptrequest(String uid,String fid) {
		String hql="from Friend where userid='"+uid+"' and friendid='"+fid+"'";
		Query query  =sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list=query.list();
		if(list==null)
		{
			return null;
		}
		else
		{
			return  list.get(0);
		}
		}*/
	  @Transactional
		public boolean saveOrUpdate(Friend friend) {
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(friend);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

	   @Transactional
		public boolean delete(Friend friend) {
			try {
				sessionFactory.getCurrentSession().delete(friend);
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
		}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public Friend newrequest(String uid,String fid) {
		String hql="from Friend where userid='"+uid+"' and friendid='"+fid+"'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list=query.list();
		if(list==null){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Transactional
	public List<Friend> getfriendlist(String uid) {
		String hql="from Friend where userid='"+uid+"' and status='a'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list = query.list();
		return list;
	}

	@Transactional
	public List<Friend> getrequestlist(String uid) {
		String hql="from Friend where friendid='"+uid+"' and status='n'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list = query.list();
		return list;
	}

	@Transactional
	public Friend setonline(String uid) {
		String hql="from Friend where userid='"+uid+"' or friendid='"+uid+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list=query.list();
		return list.get(0);
	}

	@Transactional
	public List<Friend> getonlinefriends(String uid) {
		String hql="from Friend where userid='"+uid+"'and isOnline='o' and status='a'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list=query.list();
		return list;
	}



}

