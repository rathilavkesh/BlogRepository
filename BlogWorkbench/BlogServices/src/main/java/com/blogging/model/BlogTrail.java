package com.blogging.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the blog_trail database table.
 * 
 */
@Entity
@Table(name = "blog_trail")
@NamedQuery(name = "BlogTrail.findAll", query = "SELECT b FROM BlogTrail b")
public class BlogTrail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BLOG_TRAIL_ID")
	private int blogTrailId;

	@Lob
	private String content;

	@Column(name = "PARENT_ID")
	private int parentId;

	@Column(name = "SUBMITTED_BY")
	private int submittedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUBMITTED_DATE")
	private Date submittedDate;

	// bi-directional many-to-one association to Blog
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BLOG_ID")
	private Blog blog;

	public BlogTrail() {
	}

	public int getBlogTrailId() {
		return this.blogTrailId;
	}

	public void setBlogTrailId(int blogTrailId) {
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