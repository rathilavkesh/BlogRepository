package com.blogging.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * The persistent class for the role database table.
 * 
 */
@Document(collection="role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId roleId;

	private String roleName;

	public Role() {
	}

	

	public ObjectId getRoleId() {
		return roleId;
	}



	public void setRoleId(ObjectId roleId) {
		this.roleId = roleId;
	}



	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}