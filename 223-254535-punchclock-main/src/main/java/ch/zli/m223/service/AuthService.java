package ch.zli.m223.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Arrays;
import java.util.HashSet;

@ApplicationScoped
public class AuthService {

    public String generateToken(String email) {
        return Jwt.upn(email)
                .issuer("https://example.com/issuer")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .sign();
    }
}
