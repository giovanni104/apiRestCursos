package com.example.nfcsecure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/payments/nfc").hasRole("USER")
                .requestMatchers("/api/payments").hasAnyRole("ADMIN", "AUDITOR")
                .anyRequest().permitAll())
            .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var user1 = User.withUsername("admin")
                .password("{noop}password")
                .roles("ADMIN")
                .build();

        var user2 = User.withUsername("giovanni")
                .password("{noop}clave123")
                .roles("USER")
                .build();

        var user3 = User.withUsername("auditor")
                .password("{noop}audita")
                .roles("AUDITOR")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
