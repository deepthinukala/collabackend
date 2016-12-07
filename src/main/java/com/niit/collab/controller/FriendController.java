/*package com.niit.collab.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.collab.dao.FriendDAO;
import com.niit.collab.model.Friend;

public class FriendController {
	 private static final Logger Logger = LoggerFactory.getLogger(FriendController.class);
	 
	 @Autowired
	 FriendDAO friendDAO;
	 
	 @Autowired
	 Friend friend;
	 
	 @RequestMapping(value="/myFriends",method = RequestMethod.GET)
	    public ResponseEntity<List<Friend>> getMyFriends(HttpSession session) {
	 
	  Logger.debug("->->->calling method get my friend");
	  String loggedInUserID = (String) session.getAttribute("loggedInUserID");
	  
	  User loggedInUser = (User) session.getAttribute("loggedInUser");
	  
	  List<Friend> myFriends = friendDAO.getMyFriend(loggedInUserID);
	  
	  if(myFriends.isEmpty())
	  {
	   Logger.debug("friend doest not exits for the user :" +loggedInUserID);
	   friend.setErrorCode("404");
	   friends.setErrorMessage("You does not have friends");
	   myFriends.add(friend);
	   
	  }
	  Logger.debug("send the friend list");
	  
	  return new ResponseEntity<List<Friend>>(myFriend, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/addFriend/{friendID}", method = RequestMethod.POST)
	 public ResponseEntity<Friends> sendFriendRequest(@PathVariable("friendID") String friendID,HttpSession session) {
	  
	  Logger.debug("->->->calling method sendfriendRequest");
	  User loggedInUser=(User) session.getAttribute("loggedInUser");
	  friend.setUserID(loggedInUser.getId());
	  friend.setFriendID(friendID);
	  friend.setStatus("N");
	  friend.setIsOnline('Y');
	  friendsDAO.save(friends);
	  
	  
	  return new ResponseEntity<Friends>(friends, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/unFriend/{friendID}", method = RequestMethod.GET)
	 public ResponseEntity<Friends> unFriend(@PathVariable("friendID") String friendID, HttpSession session) {
	  
	  User loggedInUser = (User) session.getAttribute("loggedInUser");
	  friends.setUserID(loggedInUser.getId());
	  friends.setFriendID(friendID);
	  friends.setStatus("U");//N -> New , R-> Rejected , A -> Accepted
	  friendsDAO.save(friends);
	  return new ResponseEntity<Friends>(friends, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/rejectFriend/{friendID}", method = RequestMethod.GET)
	 public ResponseEntity<Friends> rejectFriendFriendRequest(@PathVariable("friendID") String friendID, HttpSession session){
	  
	  User loggedInUser = (User) session.getAttribute("loggedInUser");
	  friends.setUserID(loggedInUser.getId());
	  friends.setFriendID(friendID);
	  friends.setStatus("R");
	  friendsDAO.update(friends);
	  return new ResponseEntity<Friends>(friends, HttpStatus.OK);  
	 }
	 
	 @RequestMapping(value="/getMyFriendRequests",method = RequestMethod.GET)
	 public ResponseEntity<List<Friends>> getMyFriendRequests(HttpSession session) {
	  
	  Logger.debug("->->->calling method getmyfriendRequests");
	  String loggedInUserID = (String) session.getAttribute("loggedInUserID");
	  List<Friends> myFriendRequests = friendsDAO.getNewFriendRequests(loggedInUserID);
	  return new ResponseEntity<List<Friends>>(myFriendRequests, HttpStatus.OK);
	  
	  User loggedInUser = (User) session.getAttribute("loggedInUser");
	  friendsDAO.getNewFriendRequests(loggedInUser.getId());
	  return new ResponseEntity<Friends>(friends, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/acceptFriend/{friendID}", method = RequestMethod.GET)
	 public ResponseEntity<Friends> acceptFriendRequest(@PathVariable("friendID") String friendID, HttpSession session) {
	  
	  User loggedInUser = (User) session.getAttribute("loggedInUser");
	  friends.setUserID(loggedInUser.getId());
	  friends.setFriendID(friendID);
	  friends.setStatus("A");
	  friendsDAO.update(friends);
	  return new ResponseEntity<Friends>(friends, HttpStatus.OK);
	 }
	 
	 //Just for testing purpose from restclient.
	 @RequestMapping(value="/myFriends/{id}", method = RequestMethod.GET)
	 public ResponseEntity<List<Friends>> getMyFriendsTemp(@PathVariable("id") String id) {
	 
	  List<Friends> myFriends = friendsDAO.getMyFriend(id);
	  return new ResponseEntity<List<Friends>>(myFriends, HttpStatus.OK);
	 }
	 
	  @RequestMapping(value="/friendaccept/{id}" , method = RequestMethod.PUT)
	    public  ResponseEntity<Friends> friendaccept(@PathVariable("id") String id, @RequestBody Friends friends ) 
	    {
	     friends = friendsDAO.get(friends.getId());
	  
	    if(friends==null)
	    {
	     Logger.debug("->->->->User does not exist with id "+ friends.getId());
	     friends = new Friends();
	     friends.setErrorMessage("User does not exist with id "+ friends.getId());
	      return new ResponseEntity<Friends>(friends, HttpStatus.NOT_FOUND);
	    }
	    
	    friends.setStatus("A");
	     
	    friendsDAO.update(friends);
	     
	     return new ResponseEntity<Friends>(friends, HttpStatus.OK);
	    }
	 
	  @RequestMapping(value="/friendreject/{id}" , method = RequestMethod.PUT)
	    public  ResponseEntity<Friends> friendreject(@PathVariable("id") String id, @RequestBody Friends friends ) 
	    {
	     friends = friendsDAO.get(friends.getId());
	  
	    if(friends==null)
	    {
	     Logger.debug("->->->->User does not exist with id "+ friends.getId());
	     friends = new Friends();
	     friends.setErrorMessage("User does not exist with id "+ friends.getId());
	      return new ResponseEntity<Friends>(friends, HttpStatus.NOT_FOUND);
	    }
	    
	    friends.setStatus("R");
	     
	    friendsDAO.update(friends);
	     
	     return new ResponseEntity<Friends>(friends, HttpStatus.OK);
	    }

}
*/