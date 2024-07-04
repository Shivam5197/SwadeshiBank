package com.bank.SwadeshiBank.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Loans extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private String mobileNumber;
    @Column(unique = true)
    private String loanNumber;
    private String loanType;
    private Integer totalLoan;
    private Integer amountPaid;
    private Integer outstandingAmount;
    private Integer loanTenure;
    private Long interest;
    private Long profitToBank;



}
