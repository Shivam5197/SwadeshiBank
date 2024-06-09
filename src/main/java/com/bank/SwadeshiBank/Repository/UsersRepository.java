package com.bank.SwadeshiBank.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.SwadeshiBank.Entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByMobileNumber(String mobileNumber);

	Users findByAadharNumber(String addharNumber);

	Users findByEmail(String email);

	Users findByPanNumber(String panNumber);

	Users findByUserName(String userName);

}