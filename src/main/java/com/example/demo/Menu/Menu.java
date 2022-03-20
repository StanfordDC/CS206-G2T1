package com.example.demo.Menu;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.example.demo.Business.Business;
import java.util.List;
import lombok.*;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "menu", schema = "cs206")
public class Menu {
    private  @Id @Column(name = "mid")@GeneratedValue (strategy = GenerationType.IDENTITY) Long mid;

    @Column(name="bid")
    private Long bid;

    @Column(name = "price")
    private float price;
}
