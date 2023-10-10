package com.developerstack.security.config.security;

import com.developerstack.security.config.permision.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.developerstack.security.config.permision.ApplicationUserPermission.PRODUCT_WRITE;
import static com.developerstack.security.config.permision.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeHttpRequests()
                .antMatchers("/","index").permitAll()
                .antMatchers("/api/v1/**").hasRole(USER.name())
              /*  .antMatchers(HttpMethod.GET,"/member/api/v1/**").hasAnyRole(ADMIN.name(),MANAGER.name())
                .antMatchers(HttpMethod.DELETE,"/member/api/v1/**").hasAuthority(PRODUCT_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT,"/member/api/v1/**").hasAuthority(PRODUCT_WRITE.getPermission())
                .antMatchers(HttpMethod.POST,"/member/api/v1/**").hasAuthority(PRODUCT_WRITE.getPermission())*/
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       UserDetails user= User.builder()
               .username("user")
               .password(passwordEncoder.encode("1234"))
               .authorities(USER.getSimpleGrantedAuthorities())
               .build();

        UserDetails manager= User.builder()
                .username("manager")
                .password(passwordEncoder.encode("1234"))
                .authorities(MANAGER.getSimpleGrantedAuthorities())
                .build();

        UserDetails admin= User.builder()
                .username("admin")
                .password(passwordEncoder.encode("1234"))
                .authorities(ADMIN.getSimpleGrantedAuthorities())
                .build();

       return  new InMemoryUserDetailsManager(
               user,admin,manager
       );

    }
}
