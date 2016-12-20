package com.niit.collab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Likes {
@GeneratedValue	
@Id
private int id;
private int blogid;
private int userid;
private int quantity;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getBlogid() {
	return blogid;
}
public void setBlogid(int blogid) {
	this.blogid = blogid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}
