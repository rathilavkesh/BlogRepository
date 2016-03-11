package com.javarock.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TAG_ID")
	private int tagId;

	@Column(name="TAG_NAME")
	private String tagName;

	//bi-directional many-to-many association to Blog
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="blog_tag_mapping"
		, joinColumns={
			@JoinColumn(name="TAG_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="BLOG_ID")
			}
		)
	private List<Blog> blogs;

	public Tag() {
	}

	public int getTagId() {
		return this.tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<Blog> getBlogs() {
		return this.blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

}