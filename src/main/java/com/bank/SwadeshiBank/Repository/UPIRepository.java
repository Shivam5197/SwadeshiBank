package com.bank.SwadeshiBank.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.SwadeshiBank.Entity.UPI_Entity;
import com.bank.SwadeshiBank.Entity.Users;

public interface UPIRepository extends JpaRepository<UPI_Entity,Long > {


    Optional<UPI_Entity> findByUser(Users users);
    Optional<UPI_Entity> findByUpiId(String upiId);

}
