//package com.microservices.microservices.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalAuthentication
//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityWebFilterChain(HttpSecurity httpSecurity)throws Exception {
//        httpSecurity
//                .authorizeHttpRequests(authorize -> authorize
//                        .anyRequest().authenticated()
//                )
//                .oauth2Login(withDefaults());
//        return httpSecurity.build();
//    }
//}
