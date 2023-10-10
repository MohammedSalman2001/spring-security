package com.developerstack.security.config.security;

import com.developerstack.security.config.permision.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.developerstack.security.config.permision.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/","index").permitAll()
                .antMatchers("/api/v1/**/user/**").hasRole(USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       UserDetails tarakra= User.builder()
               .username("tarakra")
               .password(passwordEncoder.encode("1234"))
               .roles(USER.name())
               .build();

        UserDetails kamal= User.builder()
                .username("kamal")
                .password(passwordEncoder.encode("1234"))
                .roles(MANAGER.name())
                .build();

        UserDetails nalaka= User.builder()
                .username("nalaka")
                .password(passwordEncoder.encode("1234"))
                .roles(ADMIN.name())
                .build();

       return  new InMemoryUserDetailsManager(
               tarakra,nalaka,kamal
       );

    }
}
