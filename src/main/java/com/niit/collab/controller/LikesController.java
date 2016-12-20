package com.niit.collab.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.dao.LikesDAO;
import com.niit.collab.model.Blog;
import com.niit.collab.model.Likes;

@RestController
public class LikesController {
	@Autowired
	private LikesDAO likesDAO;
	@Autowired
	Blog blog;
	
	 public static final Logger log=LoggerFactory.getLogger(LikesController.class);
	
@PostMapping(value="/likeblog/{bid}")
	
	public ResponseEntity<Likes> likes(Likes likes,HttpSession session,@PathVariable("bid") int bid){
		 log.info("like operation start============================================================================");
		 int uid=(Integer) session.getAttribute("uid");
			  // Likes likes2= new Likes(); 
			   log.debug("blog id"+bid);
			   likes.setBlogid(blog.getBlogid());
			 likes.setUserid(uid);
			 likes.setBlogid(bid);
			   likes.setQuantity(1);
			  likesDAO.saveOrUpdate(likes);
			System.out.println("opeartion over");
   return new ResponseEntity<Likes>(likes,HttpStatus.OK);
	}
	
	@GetMapping(value="/getlikes/{blogid}")
	public ResponseEntity<Likes> likes(@PathVariable("blogid") int blogid){
		 log.info("get like start============================================================================");
		/*List<Likes> likes =likesDAO.list(bid);*/
		 likesDAO.likeget(blogid);
		return new ResponseEntity<Likes>(HttpStatus.OK);
	}


}
