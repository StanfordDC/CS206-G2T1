package com.example.demo.Business;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BusinessUserDetailsService implements UserDetailsService{
    
    private BusinessRepository business;
 
    public BusinessUserDetailsService(BusinessRepository business) {
        this.business = business;
    }
    /** To return a UserDetails for Spring Security 
     *  Note that the method takes only a username.
        The UserDetails interface has methods to get the password.
    */
    
    public UserDetails loadUserByUsername(String UEN)  throws UsernameNotFoundException {
        return business.findByUEN(UEN)
            .orElseThrow(() -> new BusinessNotFoundException(UEN));
    }
}
