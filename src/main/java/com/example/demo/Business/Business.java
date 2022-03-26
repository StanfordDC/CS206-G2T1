package com.example.demo.Business;

// import com.example.demo.Mall.Mall;
import com.example.demo.Menu.Menu;
import com.example.demo.Order.Order;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "business", schema = "cs206")
public class Business implements UserDetails{

    @Id @Column(name = "bid") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    // @NotNull(message = "Business UEN should not be null")
    @Column(name = "uen")
    private String UEN;

    @NotNull(message = "Business name should not be null")
    private String name;


    @NotNull(message = "Password should not be null")
    private String password;

    // @NotNull(message = "Business contact number should not be null")
    @Column(name = "phone_no")
    private String contact_number;

    @NotNull(message = "Mall ID should not be null")
    @Column(name = "sid")
    private long mid;

    // @NotNull(message = "waiting time should not be null") //we generate
    @Column(name = "bwaiting_time")
    private int waiting_time;

    private String website;

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

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    // @OneToOne(mappedBy = "business",
    // cascade = CascadeType.ALL)
    // private Menu menu;

    // @OneToMany(mappedBy = "business",
    // cascade = CascadeType.ALL)
    // private Order orders;

    // @OneToMany(mappedBy = "business",
    // cascade = CascadeType.ALL)
    // private Mall mall;

    // @OneToMany(mappedBy = "business",
    // cascade = CascadeType.ALL)
    // private Table table; // list of tables?

    public Business(String UEN, String name, String password, long mid) {
        this.UEN = UEN;
        this.name = name;
        this.password = password;
        this.mid = mid;
        this.waiting_time = 0;
    }

    // public Business() {
    //     this.UEN = "hello123";
    // }

    // public Business(@JsonProperty("UEN") String UEN, @JsonProperty("name") String name, @JsonProperty("contact_number") String contact_number, @JsonProperty("website") String website) {
    //     this.UEN = UEN;
    //     this.name = name;
    //     this.contact_number = contact_number;
    //     this.website = website;
    // }

    // // @NotNull(message = "Business contact number should not be null")
    // @Column(name = "phone_no")
    // private String contact_number;

    // @NotNull(message = "Business opening hours should not be null")
    // private String opening_hours;
}
