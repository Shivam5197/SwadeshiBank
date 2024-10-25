package com.bank.SwadeshiBank.Entity;


import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transactions extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long transactionId;
    private Long toAccountNumber;
    private String debitedOrCredited;
    private Long amount;
    private Long fromAccountNumber;
    private String nameInAccount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionTime;
    private String bankName;
    private String ifscCode;
    private String transactionType;
    private String creditedOrDebited;
    private Long feeOrCharges;
    private String transactionStatus;


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

    // Automatically set the current time before persisting
    @PrePersist
    protected void onCreate() {
        this.transactionTime = new Date();
    }
}