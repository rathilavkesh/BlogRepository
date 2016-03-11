package com.javarock.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the blog database table.
 */
@Entity
@NamedQuery(name = "Blog.findAll", query = "SELECT b FROM Blog b")
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BLOG_ID")
	private int blogId;

	@Lob
	private String content;

	private String description;

	@Column(name = "expiry_period")
	private int expiryPeriod;

	@Column(name = "IS_VERIFIED")
	private int isVerified;

	@Column(name = "SUBMITTED_BY")
	private int submittedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUBMITTED_DATE")
	private Date submittedDate;

	private String type;

	@Column(name = "UPDATED_BY")
	private int updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@OneToMany(mappedBy = "blog", fetch=FetchType.LAZY)
	private List<BlogTrail> blogTrails;

	@ManyToMany(mappedBy = "blogs", fetch=FetchType.LAZY)
	private List<Tag> tags;

	public Blog() {
	}

	public int getBlogId() {
		return this.blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
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

	public List<BlogTrail> getBlogTrails() {
		return this.blogTrails;
	}

	public void setBlogTrails(List<BlogTrail> blogTrails) {
		this.blogTrails = blogTrails;
	}

	public BlogTrail addBlogTrail(BlogTrail blogTrail) {
		getBlogTrails().add(blogTrail);
		blogTrail.setBlog(this);

		return blogTrail;
	}

	public BlogTrail removeBlogTrail(BlogTrail blogTrail) {
		getBlogTrails().remove(blogTrail);
		blogTrail.setBlog(null);

		return blogTrail;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}