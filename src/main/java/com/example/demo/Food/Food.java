package com.example.demo.Food;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
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
@Table(name = "food", schema = "cs206")
public class Food{
    private  @Id @Column(name = "fid")@GeneratedValue (strategy = GenerationType.IDENTITY) Long fid;

    @NotNull(message = "Food name should not be null") 
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "bid")
    private long bid;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "image")
    @Lob
    private String image;
}

