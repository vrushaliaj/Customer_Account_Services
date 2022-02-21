package com.example.Customer_Service.Feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixFallBackFactory implements FallbackFactory<AccountFeignClient> {
    @Override
    public AccountFeignClient create(Throwable cause) {

        System.out.println("fallback; reason was: " + cause.getMessage());
        return null;
    }

}
