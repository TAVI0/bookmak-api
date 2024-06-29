package com.tavio.bookmarkapi.web.controller;

import com.tavio.bookmarkapi.domain.dto.LoginDto;
import com.tavio.bookmarkapi.web.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        System.out.println("AuthController initialized");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody LoginDto loginDto){
        System.out.println("Login attempt for user: " + loginDto.getUsername());
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);
        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());

        String jwt = this.jwtUtil.create(loginDto.getUsername());
        loginDto.setToken(jwt);
        loginDto.setPassword("");

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwt).body(loginDto);
    }

    @GetMapping("/getUserByJWT/{jwt}")
    public String getUserByJWT(@PathVariable String jwt){
        System.out.println(jwtUtil.getUsername(jwt));

        return jwtUtil.getUsername(jwt);
    }
}
