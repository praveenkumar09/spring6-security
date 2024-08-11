package com.luv2code.springboot.cruddemo.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Value("${user.password}")
    private String userPassword;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails johnDetails = User.builder()
                .username("john")
                .password(userPassword)
                .roles("EMPLOYEE")
                .build();

        UserDetails maryDetails = User.builder()
                .username("mary")
                .password(userPassword)
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susanDetails = User.builder()
                .username("susan")
                .password(userPassword)
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(johnDetails, maryDetails, susanDetails);
    }
}
