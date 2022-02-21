package com.example.Customer_Service.Repo;

import com.example.Customer_Service.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,Integer> {
}
