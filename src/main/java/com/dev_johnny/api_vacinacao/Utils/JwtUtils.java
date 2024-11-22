package com.dev_johnny.api_vacinacao.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final Dotenv dotenv = Dotenv.load();

    public String generateToken(String username) {

        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + dotenv.get("JWT-EXPIRATION")))
                .sign(Algorithm.HMAC256( dotenv.get("JWT-TOKEN")));
    }

    public String validateTokenAndGetUsername(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(dotenv.get("JWT-TOKEN"))).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Invalid JWT Token", e);
        }
    }
}
