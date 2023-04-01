package com.dawapal.pcs.config;

import com.dawapal.pcs.auth.CustomUserDetailsService;
import com.dawapal.pcs.web.LoggingAccessDeniedHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
     
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((requests) -> {
                    try {
                        requests
                        .requestMatchers("/").authenticated()
                        .anyRequest().permitAll()
                        .and()
                        .formLogin()
                            .usernameParameter("login_name")
                            .defaultSuccessUrl("/")
                            .permitAll()
                        .and()
                        .exceptionHandling()
                            .accessDeniedHandler(accessDeniedHandler)
                            .and()
                        .logout().logoutSuccessUrl("/");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                });

                        
		return http.build();
	}
}
