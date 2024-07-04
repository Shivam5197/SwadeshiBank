package com.bank.SwadeshiBank.SecurityConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {

	  private static final Logger log = LogManager.getLogger(SecurityConfig.class);

	
    private final UserDetailsService userDetailsService;

    @Autowired
    private  CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    public SecurityConfig(CustomUserDetailService customUserDetailService) {
    	this.userDetailsService = customUserDetailService;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class).authenticationProvider(daoAuthenticationProvider()).build();
    }

    @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/", "/swadeshiBank/v1/", "/swadeshiBank/v1/**", "/WEB-INF/views/open/*.jsp", "/Images/home/**").permitAll()
                                // Public pages
                                .requestMatchers("/swadeshiBank/v1/customer/*").authenticated() // Authenticated users
                                .requestMatchers("/swadeshiBank/v1/admin/*", "/WEB-INF/views/admin/*.jsp").hasRole("ADMIN") // Admin users
                                .requestMatchers("/swadeshiBank/v1/management/*").hasRole("MANAGER") // Manager users
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                                .loginPage("/swadeshiBank/v1/login")
                                .loginProcessingUrl("/swadeshiBank/v1/processLogin")
                                .successHandler(new CustomAuthenticationSuccessHandler())
                                .failureHandler(customAuthenticationFailureHandler)
                                .permitAll()
                )
                .logout(logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/swadeshiBank/v1/logout"))
                                .logoutSuccessUrl("/swadeshiBank/v1/login?logout")
                                .invalidateHttpSession(true)
                                .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
    	 return new BCryptPasswordEncoder();
    }
    
}

