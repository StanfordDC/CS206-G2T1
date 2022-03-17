package com.example.demo.Business;

import com.example.demo.Mall.Mall;
import com.example.demo.Menu.Menu;
import com.example.demo.Order.Order;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
// @AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Business {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "bid")
    private UUID id;

    @NotNull(message = "Business UEN should not be null")
    @Column(name = "uen")
    private String UEN;

    @NotNull(message = "Business name should not be null")
    // @Column(name = "business_name")
    private String name;

    // @NotNull(message = "Business contact number should not be null")
    @Column(name = "phone_no")
    private String contact_number;

    // @NotNull(message = "Business webpage should not be null")
    private String website;

    // @NotNull(message = "Business opening hours should not be null")
    // private String opening_hours;

    // @NotNull(message = "waiting time should not be null") //we generate
    @Column(name = "bwaiting_time")
    private int waiting_time;

    @OneToOne(mappedBy = "business",
    cascade = CascadeType.ALL)
    private Menu menu;

    @OneToMany(mappedBy = "business",
    cascade = CascadeType.ALL)
    private Order orders;

    @OneToMany(mappedBy = "business",
    cascade = CascadeType.ALL)
    private Mall mall;

    @OneToMany(mappedBy = "business",
    cascade = CascadeType.ALL)
    private Table table; // list of tables?

    // public Business(String UEN, String name, String contact_number, String website) {
    //     this.UEN = UEN;
    //     this.name = name;
    //     this.contact_number = contact_number;
    //     this.website = website;
    // }

    public Business(@JsonProperty("UEN") String UEN, @JsonProperty("name") String name, @JsonProperty("contact_number") String contact_number, @JsonProperty("website") String website) {
        this.UEN = UEN;
        this.name = name;
        this.contact_number = contact_number;
        this.website = website;
    }
}
