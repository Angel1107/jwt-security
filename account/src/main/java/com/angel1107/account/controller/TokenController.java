package com.angel1107.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angel1107.account.config.JwtValidator;
import com.angel1107.account.model.JwtUser;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
    private JwtValidator jwtValidator=new JwtValidator();

    @RequestMapping("/generator")
    public String generate( JwtUser jwtUser) {
        return jwtValidator.generate(jwtUser);
    }
    
    @RequestMapping("/validate")
    public String validate( String token) {
    	JwtUser jwtUser= jwtValidator.validate(token);
        return jwtUser.getUserName();
    }
    public static void main(String[] args) {
    	TokenController t=new TokenController();
    	JwtUser jwtUser=new JwtUser();
    	jwtUser.setRole("admin");
    	jwtUser.setUserName("angel1107");
    	jwtUser.setId(2);
    	
    	System.out.println(t.generate(jwtUser));
//    	eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbmdlbDExMDciLCJ1c2VySWQiOiIyIiwicm9sZSI6ImFkbWluIn0.MObx3uRa8xsSLBfDtHDumE2DC-3RrmIXHVIzSZ8eSe27LMTR2DrvpYC5AS_4MKt1EKLHOreW4XlKTDQJHDpQFw
//    	angel1107
    	System.out.println(t.validate(t.generate(jwtUser)));		
    	
	}
    
    
}
