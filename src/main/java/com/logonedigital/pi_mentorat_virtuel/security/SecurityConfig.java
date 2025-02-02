package com.logonedigital.pi_mentorat_virtuel.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
   /** @Override
    protected void configure (HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authentificated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }**/
}
