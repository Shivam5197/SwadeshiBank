package com.bank.SwadeshiBank.DTO;

import java.time.LocalDateTime;

import com.bank.SwadeshiBank.Entity.Accounts;
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
public class NetBankingDTO {

    private Long netBankId;
    private String userName;
    private String ifscCode;
    private String accountHolderName;
    private String password;
    private LocalDateTime localDateTime;
    private Integer status;

    private Accounts account;

    private Users user;


    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return   objectMapper.writeValueAsString(this);
        }catch (JsonProcessingException e){
            e.printStackTrace();
            return super.toString();
        }

    }
}





