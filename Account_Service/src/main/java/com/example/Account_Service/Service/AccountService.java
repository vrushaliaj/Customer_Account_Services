package com.example.Account_Service.Service;

import com.example.Account_Service.Model.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAllAccount();

    public Account addAccount(Account account);
    public Account findById(Integer id);
}
