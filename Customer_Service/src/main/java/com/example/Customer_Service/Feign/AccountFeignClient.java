package com.example.Customer_Service.Feign;

import com.example.Customer_Service.Model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ACCOUNT-SERVICE")
public class AccountFeignClient {
    /*
    @GetMapping(value = "/account/id/{id}")
    Account getIds(@PathVariable Integer id);

    @GetMapping("/accounts")
    ResponseEntity<List<Account>> getAllAccount();*/
}
