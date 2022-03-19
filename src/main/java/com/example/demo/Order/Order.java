package com.example.demo.Order;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.example.demo.Business.Business;
import com.example.demo.Customer.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bid")
    private Business business;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cid")
    private Customer customer;

    @Column(name = "total_price")
    private float price;

    @Column(name="odate")
    private LocalDateTime date; 

    @NotNull(message = "waiting time should not be null")
    @Column(name = "cwaiting_time")
    private String waiting_time;

    @Column(name = "pax")
    private int pax;

    @Column(name = "order_status")
    private int order_status;

    @Column(name = "refund_status")
    private int refund_status;

    @OneToMany(mappedBy = "order",
                    cascade = CascadeType.ALL)
    private List<Order_food> order_foods;
}
