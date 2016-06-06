package com.blogging.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * The persistent class for the country database table.
 * 
 */
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId countryId;

	private String name;

	public Country() {
	}
	

	public ObjectId getCountryId() {
		return countryId;
	}

	public void setCountryId(ObjectId countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}