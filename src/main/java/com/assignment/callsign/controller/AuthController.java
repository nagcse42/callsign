package com.assignment.callsign.controller;

import com.assignment.callsign.models.AuthRequest;
import com.assignment.callsign.models.AuthResponse;
import com.assignment.callsign.service.UserAuthDetailsService;
import com.assignment.callsign.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthDetailsService userAuthDetailsService;

    @Autowired
    private JWTUtils jwtUtils;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthRequest authRequest) throws Exception {
        return getAuthResponseResponseEntity(authRequest);
    }

    @RequestMapping(value = "/authuser", method = RequestMethod.POST)
    public ResponseEntity<AuthResponse> authUser(@RequestBody AuthRequest authRequest) throws Exception {
        return getAuthResponseResponseEntity(authRequest);
    }

    private ResponseEntity<AuthResponse> getAuthResponseResponseEntity(AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (BadCredentialsException exception) {
            throw new Exception("Incorrect username or password", exception);
        }

        final UserDetails userDetails = userAuthDetailsService.loadUserByUsername(authRequest.getUserName());
        final String jwtToken = jwtUtils.generateToken(userDetails);

        AuthResponse authResponse = new AuthResponse(jwtToken);
        return ResponseEntity.ok(authResponse);
    }
}
