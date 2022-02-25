package com.example.Customer_Service.Repo;

import com.example.Customer_Service.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,Integer> {
    Optional<Customer> findByCustomerId(Integer id);
}
