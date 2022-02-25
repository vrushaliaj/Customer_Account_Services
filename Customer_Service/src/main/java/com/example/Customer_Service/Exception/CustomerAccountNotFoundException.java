package com.example.Customer_Service.Exception;

public class CustomerAccountNotFoundException extends RuntimeException{
    public CustomerAccountNotFoundException(String message)
    {
        super(message);
    }
}
