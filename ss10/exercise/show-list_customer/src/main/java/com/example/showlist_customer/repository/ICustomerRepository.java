package com.example.showlist_customer.repository;

import com.example.showlist_customer.model.Customer;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerRepository {
   List<Customer> showAll();
}
