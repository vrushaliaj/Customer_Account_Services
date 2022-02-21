package com.example.Customer_Service.Config;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

import java.util.Date;

public class MyErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String s, Response response) {
        Exception exception = defaultErrorDecoder.decode(s, response);

        if(exception instanceof RetryableException){
            return exception;
        }


        if(response.status() == 503){
            System.out.println("Retrying in ...");
            return new RetryableException(response.status(), "503 error", response.request().httpMethod(), new Date(),response.request());
        }

        /*if (HttpStatus.valueOf(response.status()).is5xxServerError()) {
            return new RetryableException(response.status(), "50x error", response.request().httpMethod(), new Date(),response.request());
        }*/

        return exception;
    }
}
