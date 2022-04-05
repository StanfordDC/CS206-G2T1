package com.example.demo.Order;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.example.demo.Food.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "order_food", schema = "cs206")
public class Order_Food {
    private  @Id @Column(name = "ofid")@GeneratedValue (strategy = GenerationType.IDENTITY) Long ofid;

    @Column(name = "oid")
    private Long oid;

    @Column(name = "fid")
    private Long fid;

    @NotNull(message = "Food name should not be null") 
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "image")
    @Lob
    private String image;
}