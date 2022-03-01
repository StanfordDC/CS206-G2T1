package com.example.demo.Shop_tables;
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
public class Shop_tables {
    private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;
}
