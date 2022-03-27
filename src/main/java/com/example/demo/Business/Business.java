package com.example.demo.Business;

import com.example.demo.Table.Tables;
import com.fasterxml.jackson.annotation.JsonIgnore;

// import com.example.demo.Mall.Mall;
// import com.example.demo.Menu.Menu;
// import com.example.demo.Order.Order;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "business", schema = "cs206")
public class Business {

    @Id @Column(name = "bid") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    @NotNull(message = "Business UEN should not be null")
    @Column(name = "uen")
    private String UEN;

    @NotNull(message = "Business name should not be null")
    private String name;

    @NotNull(message = "Password should not be null")
    private String password;

    @NotNull(message = "Business contact number should not be null")
    @Column(name = "phone_no")
    private String contact_number;

    @NotNull(message = "Mall ID should not be null")
    @Column(name = "sid")
    private long mid;

    @Column(name = "no_of_2pax")
    private int no_of_2pax;

    @Column(name = "no_of_5pax")
    private int no_of_5pax;

    @Column(name = "bwaiting_time_2pax")
    @JsonIgnore
    private LocalDateTime waiting_time_2pax;

    @Column(name = "bwaiting_time_5pax")
    @JsonIgnore
    private LocalDateTime waiting_time_5pax;

    private String website;

    // @OneToOne(mappedBy = "business",
    // cascade = CascadeType.ALL)
    // private Menu menu;

    // @OneToMany(mappedBy = "business",
    // cascade = CascadeType.ALL)
    // private Order orders;

    // @OneToMany(mappedBy = "business",
    // cascade = CascadeType.ALL)
    // private Mall mall;

    @OneToMany(mappedBy = "business",
    cascade = CascadeType.ALL)
    private List<Tables> tableList; 

    public Business(String UEN, String name, String password, long mid, String contact_number) {
        this.UEN = UEN;
        this.name = name;
        this.password = password;
        this.mid = mid;
        this.contact_number = contact_number;
        this.waiting_time_2pax = java.time.LocalDateTime.now();
        this.waiting_time_5pax = java.time.LocalDateTime.now();
    }
}
