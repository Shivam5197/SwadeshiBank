package com.bank.SwadeshiBank.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UPI_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long globalId;
    private String upiId;
    private String ifscCode;
    private String contactNumber;

    private String contactEmail;
    private String UPI_CODE;

    @OneToOne
    @JoinColumn(name = "account_number")
    @JsonIgnore
    private Accounts account;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;

}
