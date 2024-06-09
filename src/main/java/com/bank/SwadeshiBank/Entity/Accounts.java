package com.bank.SwadeshiBank.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Accounts extends BaseEntity{


    @Id
    @Column(unique = true)
    private Long accountNumber;

    private String ifscCode;
    private Long userId;
    private String accountType;
    private String branchAddress;
    private String branchState;
    private String branchCity;
    private String branchPincode;
    private Long balanceAmount;
    private Boolean netBanking;
    private Long initialFunds;

    
}
