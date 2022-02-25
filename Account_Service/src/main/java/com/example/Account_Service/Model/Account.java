package com.example.Account_Service.Model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name = "account_details")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;
    @NotNull
    private  int customerId;
    @NotNull(message="account type not empty")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @NotEmpty(message="account name not empty")
    private String accountName;
    private Date createdDate;
    private Double accountBalance;

    public Account(int customerId, AccountType accountType, String accountName, Date createdDate, Double accountBalance) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.accountName = accountName;
        this.createdDate = createdDate;
        this.accountBalance = accountBalance;
    }
}
