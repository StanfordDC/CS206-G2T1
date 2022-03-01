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
    private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;
}
