package com.bank.SwadeshiBank.DTO;

import com.bank.SwadeshiBank.Entity.Accounts;
import com.bank.SwadeshiBank.Entity.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UPIDTO {

    private Long globalId;
    private String upiId;
    private String ifscCode;
    private String contactNumber;
    private Integer status;

    private String contactEmail;
    private String UPI_CODE;
    private String responseMessage;

    private Accounts account;

    private Users user;
}
