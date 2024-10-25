package com.bank.SwadeshiBank.DTO;

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
public class TransactionsDTO {


    private Long transactionId;
    private Long toAccountNumber;
    private String debitedOrCredited;
    private Long amount;
    private Long fromAccountNumber;
    private String nameInAccount;
    private String transactionTime;
    private String bankName;
    private String ifscCode;
    private String transactionType;
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
}
