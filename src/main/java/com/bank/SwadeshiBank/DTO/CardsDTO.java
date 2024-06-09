package com.bank.SwadeshiBank.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardsDTO {

	private Long cardId;
    private String cardType;
    private Long accountNumber;
    private Long totalCardAmount;
    private Long remainingCardAmount;
    private Long cardNumber;
    private String expiryDate;
    private Integer cvv;

}