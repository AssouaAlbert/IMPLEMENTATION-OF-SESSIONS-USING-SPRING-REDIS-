package com.aassoua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home", "/news").permitAll()  // Allow public access to /home and /news
                        .requestMatchers("/profile").authenticated()  // Require authentication for /profile
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Custom login page
                        .defaultSuccessUrl("/home", true)  // Redirect to "/home" after successful login
                        .permitAll()  // Allow access to the login page for all users
                ).logout(logout -> logout
                        .logoutUrl("/logout")  // URL to trigger logout
                        .logoutSuccessUrl("/login?logout")  // Redirect to login page after logout
                        .invalidateHttpSession(true)  // Invalidate session
                        .clearAuthentication(true)  // Clear authentication
                        .deleteCookies("JSESSIONID")  // Optionally delete cookies
                        .permitAll()  // Allow everyone to log out
                );

        return http.build();


    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build()
        );
    }
}
