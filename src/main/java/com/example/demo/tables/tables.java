package com.example.demo.tables;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import com.example.demo.Business.Business;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "shop_tables", schema = "cs206")
public class tables {
    private @Id @Column(name = "tid")@GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    @ManyToOne
    @JoinColumn(name = "bid")
    private Business business;

    @Column(name = "type")
    private int type;

    @Column(name = "availability")
    private boolean availability;
}
