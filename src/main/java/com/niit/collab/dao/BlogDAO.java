package com.niit.collab.dao;

import java.util.List;

import com.niit.collab.model.Blog;

public interface BlogDAO {

public boolean saveorUpdate(Blog blog);
public List<Blog> getBlogs();

/*Delete single Blog object*/
public boolean deleteBlog(Blog blog);

/*Fetch single blog object based on blogid*/
public Blog getBlog(int blogid);


public List<Blog> getIndividualForum(int blogid);


}
