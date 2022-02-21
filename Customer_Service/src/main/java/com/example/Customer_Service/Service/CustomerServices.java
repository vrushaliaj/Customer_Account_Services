package com.example.Customer_Service.Service;

import com.example.Customer_Service.Entity.Customer;
import com.example.Customer_Service.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServices implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<Customer> getCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return Optional.empty();
    }


}
