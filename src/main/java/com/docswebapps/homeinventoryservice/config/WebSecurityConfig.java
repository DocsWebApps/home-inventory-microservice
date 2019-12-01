package com.docswebapps.homeinventoryservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Value("${USERNAME}")
//    private String username;
//
//    @Value("${PASSWORD}")
//    private String password;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll() // Allow everything !!
                .antMatchers(HttpMethod.POST,"/api/v1/make").permitAll()
//                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/make/**").permitAll()
//                .anyRequest().authenticated()
        .and().cors()
        .and().csrf().disable();
    }
//
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        UserDetails admin =
//                User
//                        .withDefaultPasswordEncoder()
//                        .username(this.username)
//                        .password(this.password)
//                        .roles("ADMIN")
//                        .build();
//        return new InMemoryUserDetailsManager((admin));
//    }
}

