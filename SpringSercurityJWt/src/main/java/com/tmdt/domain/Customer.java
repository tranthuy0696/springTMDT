package com.tmdt.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class Customer implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int customerId;
	private String username;
	private String email;
	private String password;
	private Permission authority;
	private String address;
	private String phoneNumber;
	private LocalDateTime createDate;
	private LocalDateTime modifiedDate;

	public Customer() {

	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Permission getAuthority() {
		return authority;
	}

	public void setAuthority(Permission role) {
		this.authority = role;
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
		return "Customer [customerId=" + customerId + ", name=" + username + ", email=" + email + ", password=" + password
				+ ", role=" + authority + ", registrationDate=" + ", createDate=" + createDate
				+ ", modifiedDate=" + modifiedDate + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Permission> list=new ArrayList<Permission>();
		if(this.authority!=null)
		list.add(this.authority);
		return list;
	}

	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

}
