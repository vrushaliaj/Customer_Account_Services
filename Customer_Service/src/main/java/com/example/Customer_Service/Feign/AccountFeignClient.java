package com.example.Customer_Service.Feign;

import com.example.Customer_Service.Config.CustomerRetryClientConfig;
import com.example.Customer_Service.Model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "Account", configuration = CustomerRetryClientConfig.class,fallbackFactory = HystrixFallBackFactory.class)
//@FeignClient(name = "ACCOUNT-SERVICE", fallbackFactory = HystrixFallBackFactory.class)
public interface AccountFeignClient {

    @GetMapping(value = "/account/id/{id}")
    Account getIds(@PathVariable Integer id);

    @PostMapping(value="/account/add")
    ResponseEntity<Account> addAccount(@RequestBody Account account);
}


