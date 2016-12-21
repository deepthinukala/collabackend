package com.niit.collab.controller;


import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.dao.*;
import com.niit.collab.model.Blog;
import com.niit.collab.model.BlogLikes;
import com.niit.collab.model.Forum;

@RestController
public class BlogController {
	
	@Autowired
	private BlogDAO blogDAO;
	@Autowired 
	private BlogLikesDAO blogLikesDAO;
	
	@PostMapping(value="/createblog")
	public ResponseEntity<Blog> addblog(@RequestBody Blog blog,HttpSession session){
		System.out.println("hello");
	    int uid=(Integer) session.getAttribute("uid");
		blog.setBlogtime(new Date());
	   blog.setUserid(uid);
		blogDAO.saveorUpdate(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
	@GetMapping(value="/blog")
	public ResponseEntity<List<Blog>> listblog(){
		System.out.println("list of blog");
		List<Blog> blog =blogDAO.getBlogs();
		return new ResponseEntity<List<Blog>>(blog,HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteblog/{blogid}")
	public ResponseEntity<Blog> deleteblog(Blog blog,@PathVariable("blogid") int blogid){
		Blog blog1=blogDAO.getBlog(blogid);
		blogDAO.deleteBlog(blog1);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	@GetMapping(value="/individualblog/{blogid}")
	public ResponseEntity<Blog> individualblog(@PathVariable("blogid") int blogid){
		Blog blog=blogDAO.getBlog(blogid);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}

	
	@PostMapping(value="/likeblog/{blogid}")
	public ResponseEntity<Blog> likeblog(BlogLikes blogLikes,@PathVariable("blogid") int blogid,HttpSession session){
		int uid=(Integer) session.getAttribute("uid");
		blogLikes.setBlogid(blogid);
		blogLikes.setUserid(uid);
		blogLikes.setLikes("like");
		blogLikesDAO.saveOrUpdate(blogLikes);
		List<BlogLikes> list=blogLikesDAO.bloglist(blogid);
		Blog blog=blogDAO.getBlog(blogid);
		blog.setBloglike(list.size());
		blogDAO.saveorUpdate(blog);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}
	@DeleteMapping(value="/unlikeblog/{blogid}")
	public ResponseEntity<Blog> unlike(@PathVariable("blogid") int blogid,HttpSession session){
		int uid=(Integer) session.getAttribute("uid");
		BlogLikes blogLikes=blogLikesDAO.list(uid, blogid);
		blogLikesDAO.delete(blogLikes);
		List<BlogLikes> list=blogLikesDAO.bloglist(blogid);
		Blog blog=blogDAO.getBlog(blogid);
		blog.setBloglike(list.size());
		blogDAO.saveorUpdate(blog);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}
}
