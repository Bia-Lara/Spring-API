package com.example.api_conserto_carro.controller;

import com.example.api_conserto_carro.user.AuthenticationData;
import com.example.api_conserto_carro.user.User;
import com.example.api_conserto_carro.util.security.DadosToken;
import com.example.api_conserto_carro.util.security.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtTokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody AuthenticationData data){

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(data.login(), data.senha());

        var authentication = manager.authenticate(token);

        String generatedToken = tokenService.gerarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosToken(generatedToken));
    }
}
