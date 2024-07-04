package com.bank.SwadeshiBank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.SwadeshiBank.Entity.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {


}
