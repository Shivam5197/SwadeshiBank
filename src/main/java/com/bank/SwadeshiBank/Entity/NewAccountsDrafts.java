package com.bank.SwadeshiBank.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewAccountsDrafts {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer daftId;
	
    @Column(nullable = false, unique = true)
    private String userName;

//    private String password;
    private String fullname;
    private String fatherName;
    private String motherName;
    private String dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String category;
    @Column(unique = true)
    private String mobileNumber;
    @Column(unique = true)
    private String email;
    private String address;
    private String state;
    private String city;
    private String pinCode;
    @Column(unique = true)
    private String aadharNumber;
    @Column(unique = true)
    private String panNumber;
 //   @Column(unique = true)
//    private Integer CRN;
//    private boolean isActive;
    private String occupation;
    private String organisation;
    private Long annualIncome;

    private Long initialFunds;
    private String nominieFullName;
    private String nominieRelation;
    @Column(unique = true)
    private String nominieAadharNumber;
    @Column(unique = true)
    private String nominiePanNumber;
    @Column(unique = true)
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
