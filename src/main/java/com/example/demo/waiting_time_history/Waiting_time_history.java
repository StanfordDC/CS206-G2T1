package com.example.demo.waiting_time_history;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "waiting_time_history", schema = "cs206")
public class Waiting_time_history {
    private  @Id @Column(name = "wid") @GeneratedValue (strategy = GenerationType.IDENTITY) Long wid;

    @Column(name = "type")
    private int type;

    @Column(name = "waiting_time")
    private String waiting_time;

    @Column(name = "pax")
    private int pax;

    @Column(name = "bid")
    private Long bid;
    

}
