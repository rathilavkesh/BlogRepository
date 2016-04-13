package com.blogging.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.model.BlogTrail;
import com.blogging.service.BlogManager;

@RestController
public class BlogTrailController {
	
	@Resource
	private BlogManager blogManager;
	
	@RequestMapping(value="/blogtrail/add", produces="application/json", consumes="application/json", method=RequestMethod.POST)
    public void save(@RequestBody BlogTrail trail) {
        blogManager.storeBlogTrail(trail);
    } 
	

	
}
