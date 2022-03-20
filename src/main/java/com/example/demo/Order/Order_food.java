package com.example.demo.Order;
import javax.persistence.*;
import javax.validation.constraints.*;
import com.example.demo.Menu.Food;
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
public class Order_food {
    private  @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long ofid;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "fid")
    private Long fid;
}
