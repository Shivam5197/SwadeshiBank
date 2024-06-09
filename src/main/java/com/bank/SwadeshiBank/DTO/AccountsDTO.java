package com.bank.SwadeshiBank.DTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountsDTO {

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
