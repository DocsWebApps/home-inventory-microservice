package com.docswebapps.homeinventoryservice.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${USERNAME}")
    private String username;

    @Value("${PASSWORD}")
    private String password;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll() // Allow everything !!
//                .antMatchers(HttpMethod.GET,"/").permitAll()
//                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/make/**").permitAll()
//                .anyRequest().authenticated()
        ;
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails admin =
                User
                        .withDefaultPasswordEncoder()
                        .username(this.username)
                        .password(this.password)
                        .roles("ADMIN")
                        .build();
        return new InMemoryUserDetailsManager((admin));
    }
}

