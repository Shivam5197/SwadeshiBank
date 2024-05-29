package com.bank.SwadeshiBank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.SwadeshiBank.Entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByMobileNumber(String mobileNumber);

	
}
