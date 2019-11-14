package com.nnamdi.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.net.HttpCookie;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *
     * @param auth
     * @throws Exception
     *
     * ConfigureGlobal method configures the AuthenticationManagerBuilder class with valid user credentials and the allowed roles
     * Authentication Manager builder class creates the AuthenticationManager which is responsible for authenticating the credentials.
     * Authentication types includes inMemoryAuthentication, JDBC, LDAP
     * Configure method configures the HttpSecurity class which authorises each http request which has been made
     */

@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("nnamdi").password("$2a$10$zbak6MiWJO/wSXDjEROE6OF2aKoZQlkjWyqx8.aEad6Nm0174Mnn2").roles("ADMIN");
}

@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
    httpSecurity.authorizeRequests()
            .antMatchers("/", "/hello").permitAll()
            .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
            .and().formLogin();

}


}
