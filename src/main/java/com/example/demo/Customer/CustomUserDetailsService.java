package com.example.demo.Customer;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Primary
@Service
public class CustomUserDetailsService implements UserDetailsService{
    private CustomerRepository users;
    // private BusinessRepository business;
    public CustomUserDetailsService(CustomerRepository users) {
        this.users = users;
    }

    // public CustomUserDetailsService(BusinessRepository business) {
    //     this.business = business;
    // }

    @Override
    /** To return a UserDetails for Spring Security 
     *  Note that the method takes only a username.
        The UserDetails interface has methods to get the password.
    */
    public UserDetails loadUserByUsername(String email)  throws UsernameNotFoundException {
        return users.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Email '" + email + "' not found"));
    }
}
