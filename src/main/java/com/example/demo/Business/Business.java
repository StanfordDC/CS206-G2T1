package com.example.demo.Business;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

import com.example.demo.Menu.Menu;
import com.example.demo.Order.Order;
import com.example.demo.mall.Mall;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Business {
    private  @Id@Column(name = "bid") @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    @NotNull(message = "Business name should not be null")
    private String name;

    @NotNull(message = "waiting time should not be null")
    @Column(name = "bwaiting_time")
    private String waiting_time; // can chage to datetime varaible 

    @Column(name = "uen")
    private String UEN;

    @Digits(integer = 8, fraction=0,message = "phone number must be 8 digits")
    @Column(name = "phone_no")
    private int phone_no;

    @Column(name = "website")
    private String website;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "business",
    cascade = CascadeType.ALL)
    private Menu menu;

    @OneToMany(mappedBy = "business",
    cascade = CascadeType.ALL)
    private Order orders;

    @ManyToOne
    @JoinColumn(name = "mid")
    private Mall mall;
    

}
