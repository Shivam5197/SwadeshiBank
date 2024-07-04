package com.bank.SwadeshiBank.Mapper;

import com.bank.SwadeshiBank.DTO.CardsDTO;
import com.bank.SwadeshiBank.Entity.Card;

public class CardsMapper {


    public static CardsDTO mapToCardsDTO( Card card){
    	CardsDTO cardsDTO = new CardsDTO();
    	cardsDTO.setCardId(card.getCardId());
        cardsDTO.setCardType(card.getCardType());
        cardsDTO.setCardNumber(card.getCardNumber());
        cardsDTO.setRemainingCardAmount(card.getRemainingCardAmount());
        cardsDTO.setTotalCardAmount(card.getTotalCardAmount());
        cardsDTO.setCvv(card.getCvv());
        cardsDTO.setAccountNumber(card.getAccountNumber());
        cardsDTO.setExpiryDate(card.getExpiryDate());

        return cardsDTO;
    }


    public static Card mapToCards(CardsDTO cardsDTO){

    	Card card = new Card();
    	
        card.setCardType(cardsDTO.getCardType());
        card.setCardNumber(cardsDTO.getCardNumber());
        card.setRemainingCardAmount(cardsDTO.getRemainingCardAmount());
        card.setTotalCardAmount(cardsDTO.getTotalCardAmount());
        card.setCvv(cardsDTO.getCvv());
        card.setAccountNumber(cardsDTO.getAccountNumber());
        card.setExpiryDate(cardsDTO.getExpiryDate());

        return card;
    }

}
