package com.bank.SwadeshiBank.SecurityConfig;

import java.io.IOException;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	  private static final Logger log = LogManager.getLogger(CustomAuthenticationSuccessHandler.class);

	  
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

	 UserDetails userDetails = (UserDetails) authentication.getPrincipal();

     log.info("username Logged in is  : " + userDetails.getUsername());	
		
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String redirectURL = request.getContextPath();

        log.info("authorities : " + authorities);

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
				redirectURL = "/admin/dashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_MANAGER")) {
				redirectURL = "/management/dashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_USER")) {
				redirectURL = "/customer/dashboard";
                break;
            }
        }

        response.sendRedirect(redirectURL);
    }

}
