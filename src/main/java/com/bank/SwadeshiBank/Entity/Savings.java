package com.bank.SwadeshiBank.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Savings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savingId;
    private Long FD;
    private Long RD;
    private  Long PPF;
    private  Long NSC;
    private Long EPF;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;



}
