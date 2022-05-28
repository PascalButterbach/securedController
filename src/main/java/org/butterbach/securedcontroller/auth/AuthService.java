package org.butterbach.securedcontroller.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;

@Service
public class AuthService {

    public static final Algorithm algorithm = Algorithm.HMAC256("Hallo123!");
    public static final String issuer = "org.butterbach";

    public String generateToken(Map<String, String> roles) {

        String token = JWT.create()
                .withIssuedAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                .withExpiresAt(Date.from(LocalDateTime.now().plusDays(7).toInstant(ZoneOffset.UTC)))
                .withIssuer(issuer)
                .withClaim("roles", roles)
                .sign(algorithm);

        return token;
    }
}
