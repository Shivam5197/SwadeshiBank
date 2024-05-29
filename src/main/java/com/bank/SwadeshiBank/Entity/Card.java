package com.bank.SwadeshiBank.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Card extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    private String cardType;
    private Long accountNumber;
    private Long customerId;
    private Integer totalCardAmount;
    private Integer remainingCardAmount;
    private Long cardNumber;
    private String expiryDate;
    private Integer cvv;
}
