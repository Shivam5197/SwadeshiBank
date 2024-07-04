package com.bank.SwadeshiBank.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private Long userId;
    private Long totalCardAmount;
    private Long remainingCardAmount;
    @Column(unique = true)
    private Long cardNumber;
    private String expiryDate;
    private Integer cvv;
}
