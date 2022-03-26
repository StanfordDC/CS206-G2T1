package com.example.demo.Customer;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import jdk.jshell.spi.ExecutionControl.UserException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.demo.Customer.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        // customer.setName("aaaaaa");
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
}


