package com.student.StudentManagement.Controller;


import com.student.StudentManagement.config.Jwthelper;
import com.student.StudentManagement.dto.JWTRequest;
import com.student.StudentManagement.dto.JWTResponse;
import com.student.StudentManagement.userdetails.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class AuthController {
    @Autowired
    private Jwthelper jwthelper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/customlogin")
    public ResponseEntity<?>login(@RequestBody JWTRequest request){
        System.out.println("In AuthController login "+request);
        if(this.doAuthenticate(request)){
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getUserName());
            if(userDetails==null){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Requested user doesnot exist in our database");
            }
            String jwtToken = this.jwthelper.generateToken(userDetails);
            System.out.println("JWTToken we received is "+jwtToken);
            JWTResponse response = new JWTResponse();
            response.setJwtToken(jwtToken);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Credentials provided are incorrect !! ");
    }


    public boolean doAuthenticate(JWTRequest request){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword());
      Authentication auth =  authenticationManager.authenticate(token);
      System.out.println("User authentication status "+auth.isAuthenticated());
      return auth.isAuthenticated();
    }
}
