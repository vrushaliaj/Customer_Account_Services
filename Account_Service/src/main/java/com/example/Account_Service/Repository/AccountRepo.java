package com.example.Account_Service.Repository;

import com.example.Account_Service.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Integer> {

}
