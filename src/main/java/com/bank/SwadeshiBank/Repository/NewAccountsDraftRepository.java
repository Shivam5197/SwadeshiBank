package com.bank.SwadeshiBank.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.SwadeshiBank.Entity.NewAccountsDrafts;


public interface NewAccountsDraftRepository extends JpaRepository<NewAccountsDrafts , Integer> {

    List<NewAccountsDrafts> findAll();

    Optional<List<NewAccountsDrafts>> findByCity(String City);


}
