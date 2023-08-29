package com.example.showlist_customer.service;

import com.example.showlist_customer.model.Customer;
import com.example.showlist_customer.repository.CustomerRepository;
import com.example.showlist_customer.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements  ICustomerService{
    private  ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> showAll() {
        return customerRepository.showAll();
    }
}
