package com.example.demo.Order;
import javax.persistence.*;
import javax.validation.constraints.*;
import com.example.demo.Menu.Food;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order_food {
    private  @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;


    @Column(name = "quantity")
    private int quantity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fid")
    private Food food;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "oid")
    private Order order;



}
