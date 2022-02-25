package com.example.Account_Service.Service;

import com.example.Account_Service.Model.Account;
import com.example.Account_Service.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServices implements AccountService{
    @Autowired
    private AccountRepo repository;

    @Override
    public List<Account> getAllAccount() {
        return (List<Account>)repository.findAll();
    }


    @Override
    public Account addAccount(Account account) {
        return repository.save(account);
    }
    @Override
    public Account findById(Integer id) {
        return repository.findById(id).get();
    }

}
