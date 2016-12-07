package com.niit.collab.dao;

import java.util.List;

import com.niit.collab.model.Friend;

public interface FriendDAO {
	/*public boolean saveOrUpdate(Friend friend);
	public boolean delete(Friend friend);
	public Friend getFriend(int id);
	public List<Friend> getfriendlist(int uid);
	public List<Friend> list();
	public Friend newrequest(int id);
	public Friend acceptrequest(String uid,String fid);*/

	public boolean saveOrUpdate(Friend friend);
	public boolean delete(Friend friend);
	public Friend newrequest(String uid,String fid);
	public List<Friend> getfriendlist(String uid);
	public List<Friend> getrequestlist(String uid);
	public Friend setonline(String uid);
	public List<Friend> getonlinefriends(String uid);
}
