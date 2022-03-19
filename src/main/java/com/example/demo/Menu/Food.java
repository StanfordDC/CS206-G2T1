package com.example.demo.Menu;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import com.example.demo.Order.Order_food;
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
public class Food {
    private  @Id @Column(name = "fid")@GeneratedValue (strategy = GenerationType.IDENTITY) Long fid;

    @ManyToOne
    @JoinColumn(name = "mid")
    private Menu menu;

    @NotNull(message = "Food name should not be null") 
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "availability")
    private boolean availability;
    
    @JsonBackReference
    @OneToMany(mappedBy = "food",
                    cascade = CascadeType.ALL)
    private List<Order_food> order_foods;
}
