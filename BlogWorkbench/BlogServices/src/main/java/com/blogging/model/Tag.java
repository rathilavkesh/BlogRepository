//package com.blogging.model;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//
//import org.bson.types.ObjectId;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//
///**
// * The persistent class for the tag database table.
// * 
// */
//@Document
//public class Tag implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	private ObjectId tagId;
//
//	private String tagName;
//
//	//bi-directional many-to-many association to Blog
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(
//		name="blog_tag_mapping"
//		, joinColumns={
//			@JoinColumn(name="TAG_ID")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="BLOG_ID")
//			}
//		)
//	private List<Blog> blogs;
//
//	public Tag() {
//	}
//
//	public int getTagId() {
//		return this.tagId;
//	}
//
//	public void setTagId(int tagId) {
//		this.tagId = tagId;
//	}
//
//	public String getTagName() {
//		return this.tagName;
//	}
//
//	public void setTagName(String tagName) {
//		this.tagName = tagName;
//	}
//
//	public List<Blog> getBlogs() {
//		return this.blogs;
//	}
//
//	public void setBlogs(List<Blog> blogs) {
//		this.blogs = blogs;
//	}
//
//}