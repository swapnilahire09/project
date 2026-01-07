package com.swiftride.config;

import com.swiftride.services.CustomeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomeUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/rest/api/auth/**").permitAll()
                        .requestMatchers("/rest/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/rest/api/driver/**").hasRole("DRIVER")
                        .requestMatchers("/rest/api/passenger/**").hasRole("PASSENGER")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .userDetailsService(userDetailsService);
        return httpSecurity.build();
    }
}
