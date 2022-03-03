package com.example.demo.Mall;
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
public class Mall {
    private @Id @Column(name = "sid") @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    @NotNull(message = "Mall name should not be null") 
    private String name;

}
