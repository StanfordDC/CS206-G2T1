package com.example.demo.Mall;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import com.example.demo.Business.Business;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "mall", schema = "cs206")
public class mall {
    private @Id @Column(name = "sid") @GeneratedValue(strategy = GenerationType.IDENTITY) Long sid;

    @NotNull(message = "Mall name should not be null")
    private String name;
}
