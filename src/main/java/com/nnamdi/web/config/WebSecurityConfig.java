package com.nnamdi.web.config;

import com.nnamdi.web.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableWebSecurity
@ComponentScan(basePackages = {"com.nnamdi"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inMemoryUserDetailsManager());
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/employee**").hasRole("USER")
                .antMatchers("/admin**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
//        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
//                .and()
//                .formLogin()
//                .and()
//                .logout().permitAll().logoutSuccessUrl("/login")
//                .and()
//                .csrf().disable();
    }


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(User.withUsername("employee").password(passwordEncoder().encode("password")).roles("EMPLOYEE", "USER").build());
        userDetailsList.add(User.withUsername("admin").password(passwordEncoder().encode("password")).roles("ADMIN","USER").build());
        return new InMemoryUserDetailsManager(userDetailsList);
    }

}

/**
 * EnableWebMvc is equivalent to <mvc:annotation-driven/>. It enables support for @Controller, @RestController etc... annotated class
 * EnableWebSecurity annotation enables spring security configuration which is defined in WebSecurityConfigurerAdapter.
 * We have extended WebSecurityConfigurerAdapter, which allows us to override spring’s security default feature. In our example we want all the requests to be authenticated using the custom authentication.
 * configure(HttpSecurity http) method configures the HttpSecurity class which authorizes each HTTP request which has been made. In our example ‘/employee**’ should be allowed for the user with USER role and ‘/admin**’ should be allowed for the user with ADMIN role.
 * authorizeRequests() .antMatchers(“/employee**”).hasRole(“USER”) .antMatchers(“/manager**”).hasRole(“MANAGER”) –> All requests to must be authorized or else they should be rejected.
 * httpBasic() –> enables the Basic Authentication
 * .csrf().disable() –> Disables CSRF protection
 * configure(AuthenticationManagerBuilder auth) method configures the AuthenticationManagerBuilder class with the valid credentials and the allowed roles. The AuthenticationManagerBuilder class creates the AuthenticationManger which is responsible for authenticating the credentials.
 * In our example, we have used the InMemoryUserDetailsManager as the UserDetailsService.
 * inMemoryUserDetailsManager() methods create all the in-memory UserDetails, to start with we have added two users employee and manager.
 */
