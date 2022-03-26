package com.example.demo.Order;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.example.demo.Business.Business;
import com.example.demo.Customer.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private  @Id @Column(name = "oid") @GeneratedValue (strategy = GenerationType.IDENTITY) Long oid;

    @Column(name = "bid")
    private Long bid;

    @Column(name = "cid")
    private Long cid;

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

    @Column(name = "payment_status")
    private int payment_status;

    // public void setOrder_status(int order_status) {
    //     this.order_status = order_status;
    // }

    // public void setPayment_status(int payment_status) {
    //     this.payment_status = payment_status;
    // }

    // public void setPrice(float price) {
    //     this.price = price;
    // }

    // public void setDate(LocalDateTime date) {
    //     this.date = date;
    // }
    // public void setWaiting_time(String waiting_time) {
    //     this.waiting_time = waiting_time;
    // }

    
}
