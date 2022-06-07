package com.husen.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Role {

	@Id
	@Column(name = "rolename")
	@NotEmpty
	private String roleName;
	
	@Column(name = "roledescription")
	@NotEmpty
	private String roleDescription;
	
	
	
	
	public Role(@NotEmpty String roleName, @NotEmpty String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}
	public Role() {
		// TODO Auto-generated constructor stub
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
}
