package com.example.demo.Customers;
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
public class Customer {
    private  @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    
}
