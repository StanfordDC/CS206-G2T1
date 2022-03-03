package com.example.demo.mall;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import com.example.demo.Business.Business;
 import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "mall", schema = "cs206")
public class Mall {
    private @Id @Column(name = "sid") @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    @NotNull(message = "Mall name should not be null") 
    private String name;

    @OneToMany(mappedBy = "mall",
            cascade = CascadeType.ALL)
    private List<Business> businesses;


}
