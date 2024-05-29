package com.bank.SwadeshiBank.Repository;

import com.bank.SwadeshiBank.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card , Long> {
}
