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

import com.niit.collab.dao.JobDAO;
import com.niit.collab.model.Job;


@RestController
public class RCJob {
	@Autowired
	private JobDAO jobDAO;


	@PostMapping(value="/createjob")
	public ResponseEntity<Job> addjob(@RequestBody Job job,HttpSession session){
		System.out.println("hello");
		int uid=(Integer) session.getAttribute("uid");
		job.setDoc(new Date());
		job.setUserid(uid);
		jobDAO.saveOrUpdate(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
		
	}
	@GetMapping(value="/job")
	public ResponseEntity<List<Job>> getjobs(){
		System.out.println("list of blog");
		List<Job> job =jobDAO.getJobs();
		return new ResponseEntity<List<Job>>(job,HttpStatus.OK);
	}
	@DeleteMapping(value="/deletejob/{id}")
	public ResponseEntity<Job> deleteblog(Job job,@PathVariable("id") int id){
		Job job1=jobDAO.getJob(id);
		jobDAO.delete(job1);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
}
