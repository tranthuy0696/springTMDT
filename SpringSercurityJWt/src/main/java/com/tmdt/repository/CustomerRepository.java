package com.tmdt.repository;

import java.util.List;

import com.tmdt.domain.Customer;
import com.tmdt.exception.TmdtException;


public interface CustomerRepository {
	public List<Customer> getAllCustomer();

	public Customer findByUsername(String username);

	public void updatePassword(String password, String email);

	public void addCustomer(Customer customer) throws TmdtException;

	public Customer findByEmail(String email);
}
