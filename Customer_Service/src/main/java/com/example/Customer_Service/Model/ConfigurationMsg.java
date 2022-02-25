package com.example.Customer_Service.Model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("customer-service")
@Data
@Configuration
public class ConfigurationMsg {
    private String msg;
    private String status;
}
