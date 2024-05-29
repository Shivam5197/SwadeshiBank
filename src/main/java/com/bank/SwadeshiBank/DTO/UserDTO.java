package com.bank.SwadeshiBank.DTO;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {



	    private Long userId;
	    private String userName;
	    private String firstName;
	    private String lastName;
	    private String mobileNumber;
	    private Integer age;
	    private String address;
	    private String state;
	    private String city;
	    private String pinCode;
	    private String aadharNumber;
	    private String panNumber;
	    private boolean isActive;
	    private String profession;

	    
	    private Set<AccountsDTO> accountsSet;

	    private Set<CardsDTO> cardsSet;

	    private Set<LoansDTO> loansSet;

	    private Set<TransactionsDTO> transactionsSet;

	    private Set<AuthorityDTO> authorities = new HashSet<AuthorityDTO>();
	    
	    
	
}
