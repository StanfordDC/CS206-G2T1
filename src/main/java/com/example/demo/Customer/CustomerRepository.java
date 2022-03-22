package com.example.demo.Customer;

// import com.example.demo.Customer.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
     // define a derived query to find user by email
     Optional<Customer> findByEmail(String email);
}
