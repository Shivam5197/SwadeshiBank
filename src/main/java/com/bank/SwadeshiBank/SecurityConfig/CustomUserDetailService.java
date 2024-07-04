package com.bank.SwadeshiBank.SecurityConfig;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.SwadeshiBank.Entity.Authority;
import com.bank.SwadeshiBank.Entity.Users;
import com.bank.SwadeshiBank.Repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    /**
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */

    @Autowired
    private UsersRepository usersRepository;

	  private static final Logger log = LogManager.getLogger(CustomUserDetailService.class);

    

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
                
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(Authority authority : user.getAuthorities()){
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        
        return new User(user.getUserName(),user.getPassword(),authorities);
    }
}
