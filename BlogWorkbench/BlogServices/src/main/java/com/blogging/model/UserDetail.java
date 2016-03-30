package com.blogging.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * The persistent class for the user_details database table.
 * 
 */

public class UserDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    private ObjectId userDetailsId;

	private String city;

	private String company;

	private String occupation;

	private String state;

	private String zipCode;

	private Country country;

	public UserDetail() {
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public ObjectId getUserDetailsId() {
		return userDetailsId;
	}

	public void setUserDetailsId(ObjectId userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	
}