package com.student.StudentManagement.config;

import com.student.StudentManagement.exceptions.CustomAuthenticationException;
import com.student.StudentManagement.userdetails.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication auth = null;
        System.out.println(" Custom Authentication provider authentication details " + authentication.getPrincipal());
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(userName);
        if (userDetails == null) {
            throw new CustomAuthenticationException("Provided User not found in the database !!");
        }
        if(userName!=null && userName.equals(userDetails.getUsername())){
           if(passwordEncoder.matches(password,userDetails.getPassword())){
               auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
           }
           else{
               throw new CustomAuthenticationException("Password entered is not matching with the password in the database");
           }
        }
        else{
            throw new CustomAuthenticationException("provided UserName is null or doesnt match with the one in the database");
        }
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
       return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
