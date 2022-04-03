package com.example.demo.Queue;

import java.time.LocalDateTime;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.demo.Business.Business;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "orders_in_queue", schema = "cs206")
public class OrdersInQueue {

    @Id @Column(name = "oqid") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oqid;

    @NotNull(message = "Order Id should not be null")
    private Long oid;

    @NotNull(message = "Order status should not be null")
    private int status;

    @NotNull(message = "Business Id should not be null")
    @Column(name = "bid", nullable = false)
    private Long bid;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bid", insertable=false, updatable=false)
    private Business business;

    public OrdersInQueue(Long oid) {
        this.oid = oid;
        this.status = 0; // means in waiting queue
    }
}
