package com.tmdt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tmdt.domain.Customer;


@Mapper
public interface CustomerMapper {
	public List<Customer> getAllCustomer();

	public Customer findByUsername(String username);

	public void updatePassword(@Param("password") String password, @Param("email") String email);

	public void addCustomer(Customer customer);

	public Customer findByEmail(String email);

}
