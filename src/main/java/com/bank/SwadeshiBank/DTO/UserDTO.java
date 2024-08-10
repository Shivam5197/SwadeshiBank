//package com.bank.SwadeshiBank.DTO;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class UserDTO {
//
//
//    private Long userId;
//    private String userName;
//
//    private String password;
//    private String fullname;
//    private String fatherName;
//    private String motherName;
//    private Date dateOfBirth;
//    private String gender;
//    private String maritalStatus;
//    private String category;
//    private String mobileNumber;
//    private String email;
//    private String address;
//    private String state;
//    private String city;
//    private String pinCode;
//    private String aadharNumber;
//    private String panNumber;
//    private boolean isActive;
//    private String occupation;
//    private String organisation;
//    private Long annualIncome;
//    private Integer CRN;
//
//
//	private Integer userType;
//	/*
//	 * Nominie Details For Users;
//	 */
//    
//    private String nominieFullName;
//    private String nominieRelation;
//    private String nominieAadharNumber;
//    private String nominiePanNumber;
//    private String nominieMobileNumber;
//
//	/* accountsInformation */
//    
//    private String accountType;
//    private String branchAddress;
//    private String branchState;
//    private String branchCity;
//    private String branchPincode;
//    private Long balanceAmount;
//    private Boolean netBanking;
//    private Long initialFunds;
//    
//    
//	    private List<AccountsDTO> accountsSet;
//
//	    private List<CardsDTO> cardsSet;
//
//	    private List<LoansDTO> loansSet;
//
//	    private List<TransactionsDTO> transactionsSet;
//
//	    private Set<AuthorityDTO> authorities = new HashSet<AuthorityDTO>();
//
//		@Override
//		public String toString() {
//			return "UserDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullname="
//					+ fullname + ", fatherName=" + fatherName + ", motherName=" + motherName + ", dateOfBirth="
//					+ dateOfBirth + ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", category=" + category
//					+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + ", state="
//					+ state + ", city=" + city + ", pinCode=" + pinCode + ", aadharNumber=" + aadharNumber
//					+ ", panNumber=" + panNumber + ", isActive=" + isActive + ", occupation=" + occupation
//					+ ", organisation=" + organisation + ", annualIncome=" + annualIncome + ", CRN=" + CRN
//					+ ", userType=" + userType + ", nominieFullName=" + nominieFullName + ", nominieRelation="
//					+ nominieRelation + ", nominieAadharNumber=" + nominieAadharNumber + ", nominiePanNumber="
//					+ nominiePanNumber + ", nominieMobileNumber=" + nominieMobileNumber + ", accountType=" + accountType
//					+ ", branchAddress=" + branchAddress + ", branchState=" + branchState + ", branchCity=" + branchCity
//					+ ", branchPincode=" + branchPincode + ", balanceAmount=" + balanceAmount + ", netBanking="
//					+ netBanking + ", initialFunds=" + initialFunds + ", accountsSet=" + accountsSet + ", cardsSet="
//					+ cardsSet + ", loansSet=" + loansSet + ", transactionsSet=" + transactionsSet + ", authorities="
//					+ authorities + "]";
//		}
//
//
//		/*
//		 * @Override public String toString() { return "{\"userId\":\"" + userId +
//		 * "\", \"userName\":\"" + userName + "\", \"password\":\"" + password +
//		 * "\", \"fullname\":\"" + fullname + "\", \"fatherName\":\"" + fatherName +
//		 * "\", \"motherName\":\"" + motherName + "\", \"dateOfBirth\":\"" + dateOfBirth
//		 * + "\", \"gender\":\"" + gender + "\", \"maritalStatus\":\"" + maritalStatus +
//		 * "\", \"category\":\"" + category + "\", \"mobileNumber\":\"" + mobileNumber +
//		 * "\", \"email\":\"" + email + "\", \"address\":\"" + address +
//		 * "\", \"state\":\"" + state + "\", \"city\":\"" + city + "\", \"pinCode\":\""
//		 * + pinCode + "\", \"aadharNumber\":\"" + aadharNumber + "\", \"panNumber\":\""
//		 * + panNumber + "\", \"isActive\":\"" + isActive + "\", \"occupation\":\"" +
//		 * occupation + "\", \"organisation\":\"" + organisation +
//		 * "\", \"annualIncome\":\"" + annualIncome + "\", \"nominieFullName\":\"" +
//		 * nominieFullName + "\", \"nominieRelation\":\"" + nominieRelation +
//		 * "\", \"nominieAadharNumber\":\"" + nominieAadharNumber +
//		 * "\", \"nominiePanNumber\":\"" + nominiePanNumber +
//		 * "\", \"nominieMobileNumber\":\"" + nominieMobileNumber +
//		 * "\", \"accountType\":\"" + accountType + "\", \"branchAddress\":\"" +
//		 * branchAddress + "\", \"branchState\":\"" + branchState +
//		 * "\", \"branchCity\":\"" + branchCity + "\", \"branchPincode\":\"" +
//		 * branchPincode + "\", \"balanceAmount\":\"" + balanceAmount +
//		 * "\", \"netBanking\":\"" + netBanking + "\", \"initialFunds\":\"" +
//		 * initialFunds + "\", \"accountsSet\":\"" + accountsSet + "\", \"cardsSet\":\""
//		 * + cardsSet + "\", \"loansSet\":\"" + loansSet + "\", \"transactionsSet\":\""
//		 * + transactionsSet + "\", \"authorities\":\"" + authorities + "\"}"; }
//		 * 
//		 */
//	    
//	    
//	
//}


package com.bank.SwadeshiBank.DTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long userId;
    private String userName;
    private String password;
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
    private boolean isActive;
    private String occupation;
    private String organisation;
    private Long annualIncome;
    private Integer CRN;
    private Integer userType;
    
    private String nominieFullName;
    private String nominieRelation;
    private String nominieAadharNumber;
    private String nominiePanNumber;
    private String nominieMobileNumber;

    private String accountType;
    private Long balanceAmount;
    private Boolean UPIorNetBanking;
    private Long initialFunds;

    private List<AccountsDTO> accountsSet;
    private List<CardsDTO> cardsSet;
    private List<LoansDTO> loansSet;
    private List<TransactionsDTO> transactionsSet;
    private Set<AuthorityDTO> authorities = new HashSet<>();

//    @Override
//    public String toString() {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            return objectMapper.writeValueAsString(this);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return super.toString();
//        }
//    }

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
