package com.example.demo.Order;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.*;

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

    @Column(name = "cwaiting_time")
    private LocalDateTime waiting_time;

    @Column(name = "pax")
    private int pax;

    @Column(name = "order_status") // 0: in queue, 1: in store, 2: done
    private int order_status;

    @Column(name = "payment_status")
    private int payment_status;

}