package com.example.demo.waiting_time_history;
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
@Table(name = "waiting_time_history", schema = "cs206")
public class Waiting_time_history {
    private  @Id @Column(name = "wid") @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;

    @Column(name = "type")
    private int type;

    @Column(name = "waiting_time")
    private int waiting_time;

    @Column(name = "pax")
    private int pax;


    @OneToOne
    @JoinColumn(name = "bid")
    private Business business;
    

}
