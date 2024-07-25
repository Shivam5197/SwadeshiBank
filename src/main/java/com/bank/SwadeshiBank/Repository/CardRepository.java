package com.bank.SwadeshiBank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.SwadeshiBank.Entity.Card;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card , Long> {


    Optional<Card> findByUserId(Long id);

}
