package com.project.spe.securityconfiguration;

import com.project.spe.jwtutil.JwtResponse;
import com.project.spe.jwtutil.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService userDetailService;
    @Autowired
    JwtUtil jwtTokenUtil;
    @RequestMapping(value = "/userlogin",method = RequestMethod.POST)
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception{
        UserDetails userDetails=null;
        String jwt = null;
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(),
                            authRequest.getPassword(),null)

            );
            userDetails = userDetailService.loadUserByUsername(authRequest.getEmail());

            System.out.println(userDetails.getUsername());
            jwt = jwtTokenUtil.generateToken(userDetails);
            JwtResponse jwtstring=new JwtResponse(jwt,"success");

            return ResponseEntity.ok(jwtstring);


        }catch (Exception e){
            System.out.println("User Not Authenticated");
           // throw new UsernameNotFoundException("User name of password is incorrect");
           JwtResponse jwtResponse = new JwtResponse(jwt,"error");
            return ResponseEntity.ok(jwtResponse);
        }

    }
}
