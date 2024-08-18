package com.egov.config;

import com.egov.security.JwtAuthenticationEntryPoint;
import com.egov.security.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {

    private JwtAuthenticationEntryPoint authenticationEntryPoint;
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/user/login").permitAll();
                    authorize.requestMatchers("/user/register").permitAll();
                    authorize.requestMatchers("/admin/**").hasRole("ADMIN");
                    authorize.requestMatchers("/user/**").hasAnyRole("ADMIN", "USER");
                    authorize.requestMatchers("/scheme/**").hasAnyRole("ADMIN", "USER");
                    authorize.requestMatchers("/**").permitAll();
                    authorize.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    authorize.anyRequest().authenticated();
                })
                .httpBasic(withDefaults())
                .cors(withDefaults());

        http.exceptionHandling(exception -> exception
                .authenticationEntryPoint(authenticationEntryPoint));

        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        return request -> configuration;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
