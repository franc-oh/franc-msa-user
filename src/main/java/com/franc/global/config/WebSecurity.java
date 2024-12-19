package com.franc.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF 비활성화
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/users/**").permitAll()
                    .requestMatchers("/h2-console/**").permitAll()
                    .anyRequest().authenticated() // 위의 엔드포인트를 제외하고 인증 필요
            )
            .headers(headers -> headers
                .frameOptions(op -> op.sameOrigin())); // H2 콘솔에서 사용하는 iframe 허용

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 패스워드 인코딩
    }
}
