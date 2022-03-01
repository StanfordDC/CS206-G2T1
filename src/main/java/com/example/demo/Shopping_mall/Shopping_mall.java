package com.example.demo.Shopping_mall;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Shopping_mall {
    private @Id @Column(name = "sid") @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    @NotNull(message = "Mall name should not be null") 
    private String name;

}
