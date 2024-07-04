package com.bank.SwadeshiBank.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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