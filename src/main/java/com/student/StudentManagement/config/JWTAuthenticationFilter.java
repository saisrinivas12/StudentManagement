package com.student.StudentManagement.config;

import com.student.StudentManagement.userdetails.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Configuration
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "AUTHORIZATION";

    private static final String AUTHORIZATION_BEARER = "Bearer";
@Autowired
    private CustomUserDetailsService userDetailsService;
@Autowired
private Jwthelper jwthelper;

    private static final Logger log = LoggerFactory.getLogger(JWTAuthenticationFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);
        log.info("Header received in jwt authentication filter"+authorizationHeader);

        log.info("Request servlet path which is been accessed "+request.getServletPath());
        String jwtToken = null;
        String userName = null;
        if(authorizationHeader!=null && authorizationHeader.startsWith(AUTHORIZATION_BEARER)){
             jwtToken = authorizationHeader.substring(7);
             userName = jwthelper.getUsernameFromToken(jwtToken);

             if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
                 UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
                 if(userDetails == null)
                 {
                     log.error("userdetails we received is null cannot proceed further !!");
                 }
                 boolean isValid = this.jwthelper.validateToken(jwtToken,userDetails);
                 if(isValid){
                     UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());//this will automatically set authenticated to true need not explicitly mention
                     log.info("UsernamePasswordAuthentication token for the user "+token);
                     SecurityContextHolder.getContext().setAuthentication(token);
                 }
                 else{
                     log.info("user is not authenticated as validateToken returned false");
                 }
             }
             else{
                 log.info("either userName or securitycontext has been set ");

             }


        }
        else{
            log.info("header is null or header doesnt start with Bearer !!");
        }
        filterChain.doFilter(request,response);
    }
}
