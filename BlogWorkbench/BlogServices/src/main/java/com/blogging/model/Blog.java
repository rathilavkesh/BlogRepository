package com.blogging.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The persistent class for the blog database table.
 */

@Document(collection = "blog")
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId blogId;

	@Size(min=20)
	private String content;

	@Size(min=10)
	private String description;

	private int expiryPeriod;

	private int isVerified;

	@NotNull
	private ObjectId submittedBy;

	@NotNull
	private Date submittedDate;

	private String type;

	private ObjectId updatedBy;

	private Date updatedDate;

	private List<String> tags;
	
	private List<ObjectId> blogTrailIds;

	public Blog() {
	}

	public List<ObjectId> getBlogTrailIds() {
		return blogTrailIds;
	}



	public void setBlogTrailIds(List<ObjectId> blogTrailIds) {
		this.blogTrailIds = blogTrailIds;
	}



	public ObjectId getBlogId() {
		return blogId;
	}

	public void setBlogId(ObjectId blogId) {
		this.blogId = blogId;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ObjectId getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(ObjectId updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}