package com.niit.collab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Forum {
	@Id
	@GeneratedValue
	private int fid;
	private int f_userid;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getF_userid() {
		return f_userid;
	}
	public void setF_userid(int f_userid) {
		this.f_userid = f_userid;
	}
	public String getForumname() {
		return forumname;
	}
	public void setForumname(String forumname) {
		this.forumname = forumname;
	}
	public String getForumdesc() {
		return forumdesc;
	}
	public void setForumdesc(String forumdesc) {
		this.forumdesc = forumdesc;
	}
	public String getForumtime() {
		return forumtime;
	}
	public void setForumtime(String forumtime) {
		this.forumtime = forumtime;
	}
	private String forumname;
	private String forumdesc;
	private String forumtime;

}
