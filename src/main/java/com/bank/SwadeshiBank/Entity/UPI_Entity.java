package com.bank.SwadeshiBank.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UPI_Entity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long globalId;

    @Column(unique = true)
    private String upiId;
    private String ifscCode;
    private String contactNumber;
    private String contactEmail;
    private String UPI_CODE;
    private Integer status;

    @OneToOne
    @JoinColumn(name = "account_number")
    @JsonIgnore
    private Accounts account;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;

}
