//package com.hotel.hotelservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
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
//public class ConfigSecurity {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
//        security
//                .authorizeHttpRequests(authorizeRequests -> {
//                    authorizeRequests
//                            .requestMatchers("/hotels/**").permitAll()
//                            .anyRequest().authenticated();
//                }).oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
//                        .jwt(Customizer.withDefaults())
//                );
//
//        return security.build();
//    }
//
//}
