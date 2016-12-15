package com.niit.collab.dao;

import java.util.List;

import com.niit.collab.model.ForumComment;
import com.niit.collab.model.User;

public interface ForumCommentDAO {
	
	public boolean saveOrUpdate(ForumComment forumcomment);
	public boolean delete(ForumComment forumcomment);
	public List<ForumComment> list(int fid);
	public ForumComment get(int id);

}
