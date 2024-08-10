package com.bank.SwadeshiBank.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Accounts extends BaseEntity{


    @Id
    @Column(unique = true)
    private Long accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;

    @OneToOne(mappedBy = "account" , fetch = FetchType.LAZY)
    @JsonIgnore
    private UPI_Entity upiEntity;

    @OneToOne(mappedBy = "account" , fetch = FetchType.LAZY)
    @JsonIgnore
    private NetBankingEntity netBankingData;

    private String ifscCode;

    private String accountType;
    private String branchAddress;
    private String branchState;
    private String branchCity;
    private String branchPincode;
    private Long balanceAmount;
    private Boolean netBanking;
    private Long initialFunds;




//    @Override
//    public String toString() {
//        ObjectMapper objectMapper = new ObjectMapper();
////        objectMapper.findAndRegisterModules();
//        try {
//            return  objectMapper.writeValueAsString(this);
//        }catch (JsonProcessingException e) {
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
