package com.bank.SwadeshiBank.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    
    private String ifscCode;
    
    private String accountType;
    private String branchAddress;
    private String branchState;
    private String branchCity;
    private String branchPincode;
    private Long balanceAmount;
    private Boolean netBanking;
    private Long initialFunds;
    
    
    
    
//    @Override
//    public String toString() {
//        return "{\"accountNumber\":\"" + accountNumber 
//                + "\", \"ifscCode\":\"" + ifscCode 
//                + "\", \"accountType\":\"" + accountType 
//                + "\", \"branchAddress\":\"" + branchAddress 
//                + "\", \"branchState\":\"" + branchState 
//                + "\", \"branchCity\":\"" + branchCity 
//                + "\", \"branchPincode\":\"" + branchPincode 
//                + "\", \"balanceAmount\":\"" + balanceAmount
//                + "\", \"user\":\"" + user
//                + "\", \"netBanking\":\"" + netBanking 
//                + "\", \"initialFunds\":\"" + initialFunds + "\"}";
//    }
//    
}
