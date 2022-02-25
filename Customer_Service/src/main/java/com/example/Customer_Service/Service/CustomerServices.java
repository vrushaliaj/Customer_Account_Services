package com.example.Customer_Service.Service;

import com.example.Customer_Service.Exception.CustomerAlreadyExistsException;
import com.example.Customer_Service.Model.Account;
import com.example.Customer_Service.Model.AccountType;
import com.example.Customer_Service.Model.Customer;
import com.example.Customer_Service.Exception.CustomerNotActiveException;
import com.example.Customer_Service.Exception.CustomerNotFoundException;
import com.example.Customer_Service.Feign.AccountFeignClient;
import com.example.Customer_Service.Model.RequiredResponse;
import com.example.Customer_Service.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    AccountFeignClient accountFeignClient;

    @Override
    public List<Customer> getCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public RequiredResponse addCustomer(Customer customer) {

        if (customerRepo.findByCustomerId(customer.getCustomerId()).isPresent()) {
            throw new CustomerAlreadyExistsException("Please check customer id");
        } else {
            RequiredResponse requiredResponse = new RequiredResponse();
            Customer customer1 = customerRepo.save(customer);
            Account account = new Account(customer1.getCustomerId(), AccountType.current, customer1.getCustomerFirstName() + "-Account", new Date(), 2000.0);

            Account savedAccount = accountFeignClient.addAccount(account).getBody();


            requiredResponse.setCustomer_model(customer1);
            List<Account> accounts = Arrays.asList(savedAccount);
            requiredResponse.setAccount_models(accounts);
            return requiredResponse;
        }

    }

    @Override
    public Optional<Customer> findById(Integer id) {
        Optional<Customer> customer = customerRepo.findByCustomerId(id);
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException("Please check customer id");
        }
        if (!customer.get().getIsActive()) {
            throw new CustomerNotActiveException("Please check customer id");
        }

        return customer;
    }
}
