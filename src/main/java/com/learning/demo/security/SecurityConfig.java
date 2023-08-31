package com.learning.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                                    configurer
                                            .anyRequest().authenticated()
                                            .requestMatchers(HttpMethod.GET,"/users/").hasRole("EMPLOYEE")
                )
                                    .formLogin
                                    (form ->
                                        form
                                            .loginPage("/login-page")
                                            .loginProcessingUrl("/authenticateTheUser")
                                            .permitAll()
                                    )
                                    .logout(LogoutConfigurer::permitAll);
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
