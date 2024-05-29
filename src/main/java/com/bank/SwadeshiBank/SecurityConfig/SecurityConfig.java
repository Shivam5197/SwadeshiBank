package com.bank.SwadeshiBank.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	 http
    	 	.csrf().disable()
         .authorizeHttpRequests(authorize -> authorize
             .requestMatchers("/", "/swadeshiBank/v1/", "/swadeshiBank/v1/**", "/WEB-INF/views/open/*.jsp").permitAll() // Public pages
             .requestMatchers("/swadeshiBank/v1/account-details").authenticated() // Authenticated users
             .requestMatchers("/swadeshiBank/v1/admin").hasRole("ADMIN") // Admin users
             .requestMatchers("/swadeshiBank/v1/management").hasRole("MANAGER") // Manager users
             .anyRequest().authenticated()
         )
            .formLogin(form -> form
                .loginPage("/swadeshiBank/v1/loginPage")
                .loginProcessingUrl("/swadeshiBank/v1/processLogin")
                .defaultSuccessUrl("/swadeshiBank/v1/account-details", true)
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
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password("{noop}password")
                .roles("USER")
                .build());
        manager.createUser(User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build());
        manager.createUser(User.withUsername("manager")
                .password("{noop}manager")
                .roles("MANAGER")
                .build());
        return manager;
    }
}

