package com.bank.SwadeshiBank.DTO;


import com.bank.SwadeshiBank.Entity.Users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.writeValueAsString(this);
        }catch (JsonProcessingException e){
            e.printStackTrace();
            return super.toString();
        }
    }
}
