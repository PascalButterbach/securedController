package org.butterbach.securedcontroller.config;

import org.butterbach.securedcontroller.auth.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.addFilterBefore(new JwtAuthFilter(), BasicAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        // required if we want to use custom "roles" - otherweise spring expects something like "ROLE_ADMIN" instead of "admin"
        return new GrantedAuthorityDefaults("");
    }
}
