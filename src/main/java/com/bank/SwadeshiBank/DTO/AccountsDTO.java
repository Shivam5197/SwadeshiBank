package com.bank.SwadeshiBank.DTO;


import com.bank.SwadeshiBank.Entity.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDTO {

    private Long accountNumber;

    private String ifscCode;
    private Users user;
    private String accountType;
    private String branchAddress;
    private String branchState;
    private String branchCity;
    private String branchPincode;
    private Long balanceAmount;
    private Boolean netBanking;
    private Long initialFunds;

    
    
    @Override
	public String toString() {
		return "{\"accountNumber\":\"" + accountNumber + "\", \"ifscCode\":\"" + ifscCode + "\", \"user\":\"" + user
				+ "\", \"accountType\":\"" + accountType + "\", \"branchAddress\":\"" + branchAddress
				+ "\", \"branchState\":\"" + branchState + "\", \"branchCity\":\"" + branchCity
				+ "\", \"branchPincode\":\"" + branchPincode + "\", \"balanceAmount\":\"" + balanceAmount
				+ "\", \"netBanking\":\"" + netBanking + "\", \"initialFunds\":\"" + initialFunds + "\"}";
	}

}
