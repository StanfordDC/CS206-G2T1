package com.example.demo.Customer;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import com.example.demo.Order.Order;
import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {
    private  @Id @Column(name = "cid")@GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    @NotNull(message = "Business name should not be null")
    private String name;

    @Column(name = "email")
    private int email;

    @Column(name = "phone_no")
    private int phone_no;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "customer",
    cascade = CascadeType.ALL)
    private List<Order> orders;

    @Column(name = "card_no")
    @Digits(integer = 16, fraction=0,message = "Card must be 16 digits")
    private int card_no;

    @Column(name = "card_name")
    private String card_name;

    @Column(name = "expiry_date")
    private LocalDate expirary_date; 

    @Column(name = "security_code")
    private LocalDate security_code; 


}
