package com.smartcontact.smartcontactmanager.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig  {
    
    @Bean
    public UserDetailsService gUserDetailsService(){
        return new UserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.gUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

   // @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }
     
    // protected void configure(HttpSecurity http) throws Exception{
    //     http.authorizeRequests().requestMatchers("/admin/**").hasRole("ADMIN")
    //     .requestMatchers("/user/**").hasRole("USER")
    //     .requestMatchers("/**").permitAll().and().formLogin().loginPage("/signin").and().csrf().disable();
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER").requestMatchers("/**").permitAll().and().formLogin()
               .loginPage("/signin")
                .loginProcessingUrl("/dosignin")
                .defaultSuccessUrl("/user/index")
                .and()
                .build();
    }
    // 
//    // @Override
// protected void configure(HttpSecurity http) throws Exception {
//     http.authorizeRequests()
//             .antMatchers("/admin/**").hasRole("ADMIN")
//             .antMatchers("/user/**").hasRole("USER")
//             .antMatchers("/**").permitAll().and().formLogin()
//             .loginPage("/signin")
//             .loginProcessingUrl("/doLogin")
//             .defaultSuccessUrl("/user/index")
//             // .failureUrl("/login-fail")
//             .and().csrf().disable();
// }

  

}
