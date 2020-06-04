package com.johnebri.taskone.controller;

import java.util.Date;

public class Data {
	
	private int id;
    private String username;
    private String about;
    private Long submitted;
    private Date updated_at;
    private Long submission_count;
    private Long comment_count;
    private Long created_at;
    
    public Data() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Long getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Long submitted) {
		this.submitted = submitted;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Long getSubmission_count() {
		return submission_count;
	}

	public void setSubmission_count(Long submission_count) {
		this.submission_count = submission_count;
	}

	public Long getComment_count() {
		return comment_count;
	}

	public void setComment_count(Long comment_count) {
		this.comment_count = comment_count;
	}

	public Long getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Long created_at) {
		this.created_at = created_at;
	}

}
