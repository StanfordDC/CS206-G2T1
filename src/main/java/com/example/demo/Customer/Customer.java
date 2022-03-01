package com.example.demo.Customer;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import com.example.demo.Order.Order;

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

    @NotNull(message = "waiting time should not be null")
    @Column(name = "cwaiting_time")
    private int waiting_time;

    @OneToMany(mappedBy = "customer",
    cascade = CascadeType.ALL)
    private Order orders;

}
