package com.tradeit.tradeitinman.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable().
                //TODO

                //hier ist der fehler -> wahrscheinlich wird role nicht mitgegeben (mit der deaktivierung von csrf und cors funktionierts
                authorizeRequests()
                .antMatchers("/*").hasRole("boss")
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("dani")
                .password(encoder.encode("dani"))
                .roles("boss", "root")
                .and()
                .withUser("ryan")
                .password(encoder.encode("ryan"))
                .roles("boss", "root")
                .and()
                .withUser("matti")
                .password(encoder.encode("matti"))
                .roles("boss")
                .and()
                .withUser("marc")
                .password(encoder.encode("marc"))
                .roles("boss");
    }

}