package com.nnamdi.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@ComponentScan("com.nnamdi")
public class WebSecurityConfig implements WebMvcConfigurer {

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser((UserDetails) User.withDefaultPasswordEncoder().username("nnmadi").password("123456").roles("ADMIN").build());
        return manager;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/").authorizeRequests().anyRequest().hasRole("ADMIN").and().httpBasic();
    }
}
