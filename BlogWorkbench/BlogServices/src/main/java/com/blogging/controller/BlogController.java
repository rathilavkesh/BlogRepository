package com.blogging.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.model.Blog;
import com.blogging.service.BlogManager;

@RestController
public class BlogController {
	
	@Resource
	private BlogManager blogManager;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/blog/add", produces="application/json", consumes="application/json", method=RequestMethod.POST)
    public void save(@RequestBody Blog blog) {
        blogManager.createBlog(blog);
    }
}
