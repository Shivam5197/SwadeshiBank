package com.bank.SwadeshiBank.Entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString
public class Users extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;
    private String fullname;
    private String fatherName;
    private String motherName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
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
    @Column(unique = true)
    private Integer CRN;
    private boolean isActive;
    private String occupation;
    private String organisation;
    private Long annualIncome;

	/*
	 * Nominie Details For Users;
	 */
    
    private String nominieFullName;
    private String nominieRelation;
    @Column(unique = true)
    private String nominieAadharNumber;
    @Column(unique = true)
    private String nominiePanNumber;
    @Column(unique = true)
    private String nominieMobileNumber;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Accounts> accountsSet;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Card> cardSet;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Loans> loansSet;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Transactions> transactionsSet;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "user")
    private List<Authority> authorities = new ArrayList<Authority>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Savings> savings;

    @OneToOne(mappedBy = "user"  , fetch = FetchType.LAZY)
    private UPI_Entity upiEntity;

    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private NetBankingEntity netBankingEntity;

    // Add helper methods to add authority
    public void addAuthority(Authority authority) {
        authorities.add(authority);
        authority.setUser(this);
    }
    

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return super.toString();
        }
    }

}
