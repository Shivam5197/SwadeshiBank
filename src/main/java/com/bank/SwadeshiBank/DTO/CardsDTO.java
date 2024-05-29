package com.bank.SwadeshiBank.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardsDTO {

    private String cardType;
    private Long accountNumber;
    private Long customerId;
    private Integer totalCardAmount;
    private Integer remainingCardAmount;
    private Long cardNumber;
    private String expiryDate;
    private Integer cvv;

}