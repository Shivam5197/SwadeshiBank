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
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;
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
                                .requestMatchers("/", 
                                        "/swadeshiBank/v1/", 
                                        "/swadeshiBank/v1/**", 
                                        "/WEB-INF/views/open/*.jsp", 
                                        "/Images/home/**",
                                        "/JavaScript/Open/**",
                                        "/JavaScript/Utils/**",
                                        "/registerNewUser**", // Allows /registerNewUser and any parameters after it
                                        "/controller/**",
                                        "/lib/**" // Allow access to /lib folder
                                        ).permitAll()
                                // Public pages
                                .requestMatchers("/customer/*").authenticated() // Authenticated users
                                .requestMatchers("/admin/*", "/WEB-INF/views/admin/*.jsp").hasRole("ADMIN") // Admin users
                                .requestMatchers("/management/*").hasRole("MANAGER") // Manager users
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
                )
                //This session management will not allow more than 1 session at a time:
                .sessionManagement(session -> session
                		.maximumSessions(1)
                		.expiredUrl("/swadeshiBank/v1/login?expired")
                		.maxSessionsPreventsLogin(true)
                		.sessionRegistry(sessionRegistry())
                		);

        return http.build();
    }

    
    @Bean
    SessionRegistry sessionRegistry () {
    	return new SessionRegistryImpl();
    }
 
    
    @Bean
    HttpSessionEventPublisher httpSessionEventPublisher() {
    	return new HttpSessionEventPublisher();
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

