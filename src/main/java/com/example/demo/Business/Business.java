package com.example.demo.Business;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import com.example.demo.Menu.Menu;
import com.example.demo.Order.Order;

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
    private int waiting_time;

    @OneToOne(mappedBy = "business",
    cascade = CascadeType.ALL)
    private Menu menu;

    @OneToMany(mappedBy = "business",
    cascade = CascadeType.ALL)
    private Order orders;

    

}
