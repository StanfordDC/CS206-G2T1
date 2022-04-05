package com.example.demo.Customer;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RestController
@CrossOrigin
public class CustomerController {
    private CustomerRepository customers;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    public CustomerController(CustomerRepository customers) {
        this.customers = customers;
    }

    @PostMapping(value = "/create_customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        Customer checkUser = customers.findByEmail(customer.getEmail()).orElse(null);
        if(checkUser != null){
            throw new UserAlreadyExistsException(customer.getEmail());
        }
        customer.setAuthorities("ROLE_USER");
        customer.setPassword(encoder.encode(customer.getPassword()));
        return customers.save(customer);
    }

    @GetMapping(value = "/get_all_customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers() {
        return customers.listAllCustomer();
    }

    @GetMapping(value = "/get_customer/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Customer> getCustomerBycid(@PathVariable Long cid) {
        return customerService.getCustomer(cid);
    }

    @GetMapping("/users/login/{userEmail}/{password}")
    public Customer login(@PathVariable("userEmail") String userEmail, @PathVariable("password") String password) {
        // checks if the email exists
        Customer user = customers.findByEmail(userEmail).orElse(null);

        if (user == null) {
            throw new UsernameNotFoundException(userEmail);
        }

        // checks if the password keyed in matches existing password
        if (!encoder.matches(password, user.getPassword())) {
            throw new UsernameNotFoundException(userEmail);
        }

        return user;
    }
}


