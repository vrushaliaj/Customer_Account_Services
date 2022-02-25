package com.example.Customer_Service.Repo;

import com.example.Customer_Service.Model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {
}
