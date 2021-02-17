package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.exception.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CRMController {

	@Autowired
	private CustomerService service;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return service.getCustomers();
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) throws CustomerNotFoundException {
		if (id >= service.getCustomers().size() || id <= 0) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		return service.getCustomer(id);
	}

	@PutMapping("/customers/{id}")
	public void updateCustomer(@RequestBody Customer customer) {

		service.saveCustomer(customer);
	}

	@PostMapping("/customers")
	public void createCustomer(@RequestBody Customer customer) {
		service.saveCustomer(customer);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		service.deleteCustomer(id);
	}

}
