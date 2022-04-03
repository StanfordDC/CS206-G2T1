package com.example.demo.Table;

import java.time.LocalDateTime;  
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

import com.example.demo.Business.Business;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "shop_tables", schema = "cs206")
public class Tables {
    @Id @Column(name = "tid") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;

    @NotNull(message = "Table type should not be null")
    @Column(name = "type")
    private int type;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "twaiting_time")
    private LocalDateTime waiting_time;

    @NotNull(message = "Business Id should not be null")
    @Column(name = "bid", nullable = false)
    private Long bid;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bid", insertable=false, updatable=false)
    private Business business;

    public Tables(int type) {
        this.type = type;
        this.availability = true;
        this.waiting_time = java.time.LocalDateTime.now();
    }
}
