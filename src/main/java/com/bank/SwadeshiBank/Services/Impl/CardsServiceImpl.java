package com.bank.SwadeshiBank.Services.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.SwadeshiBank.Constants.Constants;
import com.bank.SwadeshiBank.DTO.AccountsDTO;
import com.bank.SwadeshiBank.DTO.CardsDTO;
import com.bank.SwadeshiBank.Entity.Card;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Mapper.CardsMapper;
import com.bank.SwadeshiBank.Repository.CardRepository;
import com.bank.SwadeshiBank.Services.CardsService;
import com.bank.SwadeshiBank.Utils.RandomStringGenerator;
import com.bank.SwadeshiBank.Utils.Utils;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CardsServiceImpl implements CardsService {


	  private static final Logger log = LogManager.getLogger(CardsServiceImpl.class);
	
    @Autowired
    CardRepository cardRepository;


    @Override
    public CardsDTO createCards(Users user, AccountsDTO accountsDTO, List<String> errorList) {

        CardsDTO cardsDTO = new CardsDTO();
        try {
            if (!Utils.isNull(user) && user.isActive() && !Utils.isNull(accountsDTO)) {
                cardsDTO.setCardNumber(RandomStringGenerator.generateRandomNumeric(16));
                cardsDTO.setCardType(Constants.Cards.DEBIT_CARD);
                cardsDTO.setTotalCardAmount(accountsDTO.getBalanceAmount());
                cardsDTO.setCvv(RandomStringGenerator.generateRandomNumeric(3).intValue());
                cardsDTO.setRemainingCardAmount(accountsDTO.getBalanceAmount());
                cardsDTO.setExpiryDate(LocalDateTime.now().toString());
                cardsDTO.setAccountNumber(accountsDTO.getAccountNumber());

                Card card = CardsMapper.mapToCards(cardsDTO);
                
                card.setUserId(user.getUserId());
                
                log.info("Entity we are going to save is : ---> {}", card);
                
                card = cardRepository.save(card);
                cardsDTO = CardsMapper.mapToCardsDTO(card);

            } else {
                errorList.add("Error while creating a new Card");
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorList.add("Something went wrong !");
        }
        return cardsDTO;
    }

    @Override
    public CardsDTO getCardByUser(Users user , List<String> errorList){
        CardsDTO cardsDTO = new CardsDTO();

        Card card =   cardRepository.findByUserId(user.getUserId()).orElseThrow(()-> new NoSuchElementException("Card for this user not found"));

     cardsDTO =   CardsMapper.mapToCardsDTO(card);
        log.info(cardsDTO);
        return cardsDTO;
    }

}
