/**
 * 
 */
package com.bridgelabz.crud.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bridgelabz.crud.model.Customer;

/**
 * purpose
 * @author Chaithra-Shenoy
 * Date
 * 
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	 List<Customer> findByLastName(String lastName);
}
