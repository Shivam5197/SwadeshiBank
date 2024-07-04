package com.bank.SwadeshiBank.SecurityConfig;

import java.io.IOException;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	  private static final Logger log = LogManager.getLogger(CustomAuthenticationSuccessHandler.class);

	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {


        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String redirectURL = request.getContextPath();

        log.info("authorities : " + authorities);

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
				redirectURL = "/swadeshiBank/v1/admin/dashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_MANAGER")) {
				redirectURL = "/swadeshiBank/v1/management/dashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_USER")) {
				redirectURL = "/swadeshiBank/v1/customer/dashboard";
                break;
            }
        }

        response.sendRedirect(redirectURL);
    }

}
