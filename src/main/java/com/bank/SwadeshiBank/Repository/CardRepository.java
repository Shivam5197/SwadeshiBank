package com.bank.SwadeshiBank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.SwadeshiBank.Entity.Card;

public interface CardRepository extends JpaRepository<Card , Long> {
}
