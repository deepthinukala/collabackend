package com.niit.collab.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.niit.collab.model.Blog;
import com.niit.collab.service.BlogService;

@RestController
public class RCBlog {
	
	@Autowired
	private BlogService blogService;

	@PostMapping("/CreateBlog")
	public void CreateBlog(@RequestBody Blog blog,HttpSession session) 
	{
		 blogService.createBlog(blog,session);
	}
	
	@GetMapping("/getAllBlogs")
	public String getAllBlogs()
	{
		return blogService.getAllBlogs();
	}	
	
	@DeleteMapping("/deleteBlog/{blogid}")
	public void deleteBlog(@PathVariable("blogid") int blogid)
	{
		blogService.deleteBlog(blogid);
	}
	
	@PutMapping("/editBlog/{blogid}")
	public ResponseEntity<Blog> editBlog(@PathVariable("blogid") int blogid)
	{
		Blog blog=blogService.editBlog(blogid);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
}
