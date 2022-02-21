package com.example.Customer_Service.Controller;

import com.example.Customer_Service.Entity.Customer;
import com.example.Customer_Service.Service.CustomerServices;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> list=customerServices.getCustomer();
        log.info("getcustomers");
        return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){
        Customer customer1= customerServices.addCustomer(customer);
        return new ResponseEntity<Customer>(customer1,HttpStatus.CREATED);

    }

   /*

    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Integer id){
        Optional<Customer> one= customerServices.findById(id);
        return  new ResponseEntity<Customer>(one.get(),HttpStatus.OK);
    }


    @GetMapping("/id/ids/{id}")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCentreId(@PathVariable("id") Integer id){
        RequiredResponse requiredResponse=new RequiredResponse();
        log.info("In get resource");

        Optional<Customer> cus= customerServices.findById(id); //mongo
        requiredResponse.setCustomer_model(cus.get());

        // Account accounts=  restTemplate.getForObject("http://ACCOUNT-SERVICE/account/id/"+id, Account.class);
        //  Account accounts=  restTemplate.getForObject("http://127.0.0.1:8082/account/id/"+id, Account.class);
        Account accounts =accountFeignClient.getIds(id);

        requiredResponse.setAccount_model((Account) accounts);
        return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
    }*/


}
