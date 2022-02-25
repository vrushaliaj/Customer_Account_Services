package com.example.Customer_Service.Service;

import com.example.Customer_Service.Model.Customer;
import com.example.Customer_Service.Model.RequiredResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getCustomer();

    public RequiredResponse addCustomer(Customer customer);



    Optional<Customer> findById(Integer id);

}
