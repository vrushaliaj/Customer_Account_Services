package com.example.Customer_Service.Service;

import com.example.Customer_Service.Entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    //get list of customers
    public List<Customer> getCustomer();

    //create a customer
    public Customer addCustomer(Customer customer);

    //get by id

    Optional<Customer> findById(Integer id);



}
