package com.nnamdi.web.service;


import com.nnamdi.web.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {

        User user = findUserbyUsername(username);

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.roles(user.getRoles());
        } else {
            throw new UsernameNotFoundException("User not found");
        }

        return builder.build();
    }

    private User findUserbyUsername (String username) {
        if (username.equalsIgnoreCase("admin")) {
            return new User(username, "123456", "ADMIN");
        }
        return null;
    }
}
