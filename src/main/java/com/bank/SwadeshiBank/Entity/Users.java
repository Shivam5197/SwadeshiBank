package com.bank.SwadeshiBank.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

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
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Accounts> accountsSet;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Card> cardSet;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Loans> loansSet;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Transactions> transactionsSet;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Authority> authorities = new HashSet<Authority>();
    
    
    // Add helper methods to add authority
    public void addAuthority(Authority authority) {
        authorities.add(authority);
        authority.setUser(this);
    }
    
    
	@Override
    public String toString() {
        return "{\"" +(userId != null ? "userId\":\"" + userId + "\" " : "")
                     +(userName != null ? ",\"userName\":\"" + userName + "\" " : "")
                     +(password != null ? ",\"password\":\"" + password + "\" " : "")
                     +(fullname != null ? ",\"fullname\":\"" + fullname + "\" " : "")
                     +(fatherName != null ? ",\"fatherName\":\"" + fatherName + "\" " : "")
                     +(motherName != null ? ",\"motherName\":\"" + motherName + "\" " : "")
                     +(dateOfBirth != null ? ",\"dateOfBirth\":\"" + dateOfBirth + "\" " : "")
                     +(gender != null ? ",\"gender\":\"" + gender + "\" " : "")
                     +(maritalStatus != null ? ",\"maritalStatus\":\"" + maritalStatus + "\" " : "")
                     +(category != null ? ",\"category\":\"" + category + "\" " : "")
                     +(occupation != null ? ",\"occupation\":\"" + occupation + "\" " : "")
                     +(organisation != null ? ",\"organisation\":\"" + organisation + "\" " : "")
                     +(annualIncome != null ? ",\"annualIncome\":\"" + annualIncome + "\" " : "")
                     +(nominieFullName != null ? ",\"nominieFullName\":\"" + nominieFullName + "\" " : "")
                     +(nominieRelation != null ? ",\"nominieRelation\":\"" + nominieRelation + "\" " : "")
                     +(nominieAadharNumber != null ? ",\"nominieAadharNumber\":\"" + nominieAadharNumber + "\" " : "")
                     +(nominiePanNumber != null ? ",\"nominiePanNumber\":\"" + nominiePanNumber + "\" " : "")
                     +(nominieMobileNumber != null ? ",\"nominieMobileNumber\":\"" + nominieMobileNumber + "\" " : "")
                     +(mobileNumber != null ? ",\"mobileNumber\":\"" + mobileNumber + "\" " : "")
                     +(email != null ? ",\"email\":\"" + email + "\" " : "")
                     +(address != null ? ",\"address\":\"" + address + "\" " : "")
                     +(state != null ? ",\"state\":\"" + state + "\" " : "")
                     +(city != null ? ",\"city\":\"" + city + "\" " : "")
                     +(pinCode != null ? ",\"pinCode\":\"" + pinCode + "\" " : "")
                     +(aadharNumber != null ? ",\"aadharNumber\":\"" + aadharNumber + "\" " : "")
                     +(panNumber != null ? ",\"panNumber\":\"" + panNumber + "\" " : "")
                     +(isActive != false ? ",\"isActive\":\"" + isActive + "\" " : "")
                     + (Hibernate.isInitialized(accountsSet) && accountsSet != null ? ",\"accountsSet\":" + accountsSet :"" )
                     + (Hibernate.isInitialized(cardSet) && cardSet != null ? ",\"productSellCategory\":" + cardSet   : "")
                     + (Hibernate.isInitialized(loansSet) && loansSet != null ? ",\"loansSet\":" + loansSet :"" )
                     + (Hibernate.isInitialized(transactionsSet) && transactionsSet != null ? ",\"transactionsSet\":" + transactionsSet   : "")
                     + "}\t";
    }		
    
    

}
