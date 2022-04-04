package com.example.demo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    //Create a new customer
    // public Customer addCustomer(String name){
    //     Customer newCustomer = new Customer();

    //     newCustomer.setName(name);
    //     return customerRepository.save(newCustomer);
    // }

    //Get all customers
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    //Get a customer
    public Optional<Customer> getCustomer(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }
}
