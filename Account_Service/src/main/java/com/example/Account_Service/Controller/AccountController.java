package com.example.Account_Service.Controller;

import com.example.Account_Service.Model.Account;
import com.example.Account_Service.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountServ;
    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        Account account1=  accountServ.addAccount(account);
        return  new ResponseEntity<Account>(account1, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") Integer id){
        Account one= accountServ.findById(id);
//        log.info("account by Id: {}", id);
        return  new ResponseEntity<Account>(one,HttpStatus.OK);
    }
}
