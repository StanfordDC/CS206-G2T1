package com.example.demo.Business;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import java.util.List;
import com.example.demo.Menu.Menu;
import com.example.demo.Order.Order;
import com.example.demo.mall.Mall;
import com.example.demo.waiting_time_history.Waiting_time_history;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "business", schema = "cs206")
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
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "sid")
    private Mall mall;
    
    @OneToOne(mappedBy = "business",
                    cascade = CascadeType.ALL)
    private Waiting_time_history waiting_time_history;
}
