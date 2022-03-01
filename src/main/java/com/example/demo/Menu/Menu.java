package com.example.demo.Menu;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.example.demo.Business.Business;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Menu {
    private  @Id @Column(name = "mid")@GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    @OneToOne
    @JoinColumn(name="bid")
    private Business business;

    @NotNull(message = "Menu name should not be null")  // I think that menu do not need a name 
    private String name;

    private float price;



}
