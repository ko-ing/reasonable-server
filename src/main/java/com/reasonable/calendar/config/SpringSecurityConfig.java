package com.reasonable.calendar.config;

import com.reasonable.calendar.domain.auth.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${allow-origin}")
    private String allowOrigin;

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final ReasonableAuthenticationEntryPoint authenticationEntryPoint;
    private final ReasonableAuthenticationFailureHandler authenticationFailureHandler;
    private final ReasonableAuthenticationSuccessHandler authenticationSuccessHandler;
    private final ReasonableLogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
            .and()
                .cors()
            .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
            .and()
                .formLogin()
                .loginProcessingUrl("/auth/signIn")
                .usernameParameter("userAccountId").passwordParameter("password")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
            .and()
                .logout()
                .logoutUrl("/auth/signOff")
                .logoutSuccessHandler(logoutSuccessHandler)
            .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers(HttpMethod.POST,"/hello-calendar", "/auth/signIn", "/auth/signUp", "/photo").permitAll()
//                .antMatchers("/user").hasRole("USER")
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/photo").hasRole("USER")
//                .antMatchers("/photo").hasAuthority("ADMIN")

            .anyRequest().authenticated()
            .and()
        ;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsServiceImpl);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

}
