package com.blogging.model;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The persistent class for the blog_trail database table.
 * 
 */
@Document(collection="blogtrail")
public class BlogTrail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId blogTrailId;

	private String content;

	private int parentId;

	private int submittedBy;

	private Date submittedDate;

	private Blog blog;

	public BlogTrail() {
	}

	public ObjectId getBlogTrailId() {
		return blogTrailId;
	}



	public void setBlogTrailId(ObjectId blogTrailId) {
		this.blogTrailId = blogTrailId;
	}



	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getSubmittedBy() {
		return this.submittedBy;
	}

	public void setSubmittedBy(int submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Blog getBlog() {
		return this.blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}