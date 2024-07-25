package com.bank.SwadeshiBank.DTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
public class NewAccountsDraftDTO {

	
	private Integer daftId;
	
    private String userName;

//    private String password;
    private String fullname;
    private String fatherName;
    private String motherName;
    private String dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String category;
    private String mobileNumber;
    private String email;
    private String address;
    private String state;
    private String city;
    private String pinCode;
    private String aadharNumber;
    private String panNumber;
//    private Integer CRN;
//    private boolean isActive;
    private String occupation;
    private String organisation;
    private Long annualIncome;
    private Long initialFunds;

    private String nominieFullName;
    private String nominieRelation;
    private String nominieAadharNumber;
    private String nominiePanNumber;
    private String nominieMobileNumber;

    
    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return super.toString();
        }
    }

}
