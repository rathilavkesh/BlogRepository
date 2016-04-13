package com.blogging.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	
	@NotNull
	private ObjectId blogId;

	@NotNull
	private ObjectId submittedBy;

	@NotNull
	private Date submittedDate;

	public BlogTrail() {
	}

	public ObjectId getBlogId() {
		return blogId;
	}

	public void setBlogId(ObjectId blogId) {
		this.blogId = blogId;
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

	public ObjectId getSubmittedBy() {
		return this.submittedBy;
	}

	public void setSubmittedBy(ObjectId submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}
}