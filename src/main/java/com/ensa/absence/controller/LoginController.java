package com.ensa.absence.controller;

import com.ensa.absence.constants.GeneralConstants;
import com.ensa.absence.domain.entity.AppUtilisateur;
import com.ensa.absence.payload.JwtLoginRequest;
import com.ensa.absence.payload.LoginRequest;
import com.ensa.absence.payload.LoginResponse;
import com.ensa.absence.security.JwtTokenProvider;
import com.ensa.absence.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/access-token")
    public ResponseEntity<LoginResponse> loginWithToken(@RequestBody JwtLoginRequest body) {
        String username = ((DefaultClaims) Jwts.parser().setSigningKey(GeneralConstants.JWT_SECRET).parse(body.getAccessToken()).getBody())
                .getSubject();
        AppUtilisateur appUtilisateur = userService.getAppUtilisateurByUsername(username);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ArrayList<GrantedAuthority> auth = new ArrayList<>(authentication.getAuthorities());
        String role = auth.get(0).getAuthority();
        return ResponseEntity.ok(new LoginResponse(body.getAccessToken(), username, appUtilisateur.getNom(),
                appUtilisateur.getPrenom(), role, appUtilisateur.getId()));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        AppUtilisateur appUtilisateur = userService.getAppUtilisateurByUsername(loginRequest.getUsername());
        ArrayList<GrantedAuthority> auth = new ArrayList<>(authentication.getAuthorities());
        String role = auth.get(0).getAuthority();
        return ResponseEntity.ok(new LoginResponse(jwt, loginRequest.getUsername(), appUtilisateur.getNom(),
                appUtilisateur.getPrenom(), role, appUtilisateur.getId()));
    }
}
