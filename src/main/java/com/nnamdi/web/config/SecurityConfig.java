package com.nnamdi.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jdbcUserDetailsManager()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/employee/**").hasRole("USER")
                .antMatchers("/manager/**").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

    }
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        return jdbcUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @EnableWebSecurity annotation enables spring security configuration which is defined in WebSecurityConfigurerAdapter
     * Extending WebSecurityConfigurerAdapter, allows us to override spring's security default feature. In our example we want all the
     * requests to be authenticated using the custom authentication.
     * configure(HttpSecurity http) method configures the HttpSecurity class authorizes each HTTP request which is been made.
     * In our example ‘/employee/**’ should be allowed for the user with USER role and ‘/manager/**’ should be allowed for the user with MANAGER role.
     * authorizeRequests() .antMatchers(“/employee/**”).hasRole(“USER”) .antMatchers(“/manager/**”).hasRole(“MANAGER”) –> All requests to must be authorized or else they should be rejected.
     * httpBasic() –> Enables the Basic Authentication
     * .csrf().disable() –> Enables CSRF protection
     *
     * configure(AuthenticationManagerBuilder auth) method configures the AuthenticationManagerBuilder class with the valid credentials  and the allowed roles.
     * The AuthenticationManagerBuilder class creates the AuthenticationManger which is responsible for authenticating the credentials.
     * jdbcUserDetailsManager() method connects to the database using the dataSource which we have autowired and retrieves the user details
     */
}
