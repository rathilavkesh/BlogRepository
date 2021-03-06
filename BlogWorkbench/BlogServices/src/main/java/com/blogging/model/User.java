package com.blogging.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * The persistent class for the user database table.
 * 
 */

@Document(collection="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId userId;
	
	private String thirdPartyId;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	@NotNull
	private LoginType loginType;

	@Indexed
	private String email;

	private byte isActive;
	
	private Date createdDate;

	private Date updatedDate;

	private List<ObjectId> roleId;

	private UserDetail userDetail;

	public User() {
	}


	public enum LoginType {
		FB;
	}
	
	
	
	public LoginType getLoginType() {
		return loginType;
	}



	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}



	public String getThirdPartyId() {
		return thirdPartyId;
	}



	public void setThirdPartyId(String thirdPartyId) {
		this.thirdPartyId = thirdPartyId;
	}



	public ObjectId getUserId() {
		return userId;
	}


	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}


	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	public List<ObjectId> getRoleId() {
		return roleId;
	}


	public void setRoleId(List<ObjectId> roleId) {
		this.roleId = roleId;
	}


	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	
}