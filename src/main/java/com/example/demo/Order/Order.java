package com.example.demo.Order;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.example.demo.Business.Business;
import com.example.demo.Customer.Customer;

import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "orders", schema = "cs206")
public class Order {
    private  @Id @Column(name = "oid") @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    @NotNull(message = "waiting time should not be null")
    @Column(name = "cwaiting_time")
    private int waiting_time;

    @ManyToOne
    @JoinColumn(name = "bid")
    private Business business;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Customer customer;

    @NotNull(message = "Order name should not be null")  // I think that order do not need a name 
    private String name;

    @Column(name = "total_price")
    private float price;

    @NotNull(message = "date cannot be null")
    @Column(name="odate")
    private LocalDate date; 

    @Column(name = "pax")
    private int pax;
    
}
