package com.student.StudentManagement.config;

import com.student.StudentManagement.userdetails.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String [] swaggerUrls = {
            "/auth/users/**","/auth/login/**",
            "**/swagger-resources/**",
            "/swagger-ui.html**",
            "/webjars/**",
            "favicon.ico",
            "/api/v2/**",
            "/api/v3/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-resources",
            "/swagger-resources/**"
    };
    @Autowired
    private JWTEntryPoint jwtEntryPoint;

    @Autowired
    private JWTAuthenticationFilter authenticationFilter;

    @Autowired
    private CustomAuthenticationProvider provider;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("entered into security config");
        http.csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST)
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE)
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET)
                .hasRole("NORMAL")
                .anyRequest().authenticated();
        http.addFilterBefore(authenticationFilter, BasicAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration conf) throws Exception {
        return conf.getAuthenticationManager();
    }
@Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers(swaggerUrls);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }
}
