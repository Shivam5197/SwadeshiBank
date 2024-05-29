package com.bank.SwadeshiBank.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Users extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private Integer age;
    private String address;
    private String state;
    private String city;
    private String pinCode;
    private String addharNumber;
    private String panNumber;
    private boolean isActive;
    private String profession;

    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Accounts> accountsSet;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Card> cardSet;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Loans> loansSet;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Transactions> transactionsSet;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Authority> authorities = new HashSet<Authority>();
    
    
    // Add helper methods to add authority
    public void addAuthority(Authority authority) {
        authorities.add(authority);
        authority.setUser(this);
    }
    
    

}
