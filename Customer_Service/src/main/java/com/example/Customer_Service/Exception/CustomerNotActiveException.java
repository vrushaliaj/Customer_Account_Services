package com.example.Customer_Service.Exception;

public class CustomerNotActiveException extends RuntimeException{
    public CustomerNotActiveException(String message) {
        super(message);
    }
}
