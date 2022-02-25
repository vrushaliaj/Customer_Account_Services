package com.example.Customer_Service.Model;

import com.example.Customer_Service.Model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;



    @Document(collection = "customer_details")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Customer {


        @Id
        private Integer customerId;
        @NotBlank(message = "Name cannot be blank")
        private String customerFirstName;
        private String customerMiddleName;
        private String customerLastName;
        private String customerCity;
        private Date createdDate;
        private Boolean isActive;

        private CustomerType customerType;

    }

