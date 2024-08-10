package com.bank.SwadeshiBank.Entity;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NetBankingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long netBankId;

    private String ifscCode;
    private String accountHolderName;
    private String password;
    private LocalDateTime localDateTime;


    @OneToOne
    @JoinColumn(name = "account_number")
    @JsonIgnore
    private Accounts account;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;


    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return   objectMapper.writeValueAsString(this);
        }catch (JsonProcessingException e){
            e.printStackTrace();
            return super.toString();
        }

    }
}
