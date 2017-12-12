package com.tmdt.domain;

import java.time.LocalDateTime;

import org.springframework.security.core.GrantedAuthority;

public class Permission implements GrantedAuthority{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roleId;
	private String authority;
	private LocalDateTime createDate;

	private LocalDateTime modifiedDate;

	public Permission() {

	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + authority + ", createDate=" + createDate + ", modifiedDate="
				+ modifiedDate + "]";
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	
	

}
