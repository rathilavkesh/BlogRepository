package com.blogging.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The persistent class for the blog database table.
 */

@Document(collection="blog")
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId blogId;

	private String content;

	private String description;

	private int expiryPeriod;

	private int isVerified;

	private int submittedBy;

	private Date submittedDate;

	private String type;

	private int updatedBy;

	private Date updatedDate;

	@DBRef
	private List<BlogTrail> blogTrails;

	private List<String> tags;

	public Blog() {
	}

	

	public ObjectId getBlogId() {
		return blogId;
	}



	public void setBlogId(ObjectId blogId) {
		this.blogId = blogId;
	}



	public List<BlogTrail> getBlogTrails() {
		return blogTrails;
	}



	public void setBlogTrails(List<BlogTrail> blogTrails) {
		this.blogTrails = blogTrails;
	}



	public List<String> getTags() {
		return tags;
	}



	public void setTags(List<String> tags) {
		this.tags = tags;
	}



	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExpiryPeriod() {
		return this.expiryPeriod;
	}

	public void setExpiryPeriod(int expiryPeriod) {
		this.expiryPeriod = expiryPeriod;
	}

	public int getIsVerified() {
		return this.isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	

}