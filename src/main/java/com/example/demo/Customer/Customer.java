package com.example.demo.Customer;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import com.example.demo.Order.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
// @NoArgsConstructor
@EqualsAndHashCode
@Table(name = "customers", schema = "cs206")
public class Customer implements UserDetails{
    private @Id @Column(name = "cid") @GeneratedValue(strategy = GenerationType.IDENTITY) Long cid;

    @NotNull(message = "Customer name should not be null")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private int phone_no;

    @NotNull(message = "Password should not be null")
    // @Size(min = 8, message = "Password should be at least 8 characters")
    @Column(name = "password")
    private String password;

    @Column(name = "card_no")
    private String card_no;

    @Column(name = "card_name")
    private String card_name;

    @Column(name = "expiry_date")
    private LocalDate expiry_date;

    @NotNull(message = "Authorities should not be null")
    // We define two roles/authorities: ROLE_USER or ROLE_ADMIN
    private String authorities;

    /* Return a collection of authorities (roles) granted to the user.
    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(authorities));
    }

    /*
    The various is___Expired() methods return a boolean to indicate whether
    or not the user’s account is enabled or expired.
    */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    // need to override because we using email, not username
    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    // public Customer(String name,String email, String password, String authorities){
    //     this.name = name;
    //     this.email = email;
    //     this.password = password;
    // }

    // public Customer(){
    //     this.name = "new";
    //     this.email = "abs@gmail.com";
    //     this.password = "password";
    // }
}
