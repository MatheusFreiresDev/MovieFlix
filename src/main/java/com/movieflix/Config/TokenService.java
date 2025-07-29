package com.movieflix.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.movieflix.Entity.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {
    private String codigo = "1233013210312sadkajsdjadsauidjuij103";

    public String token(User user){
        Algorithm algorithm = Algorithm.HMAC256(codigo);
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userID", user.getName())
                .withClaim("name", user.getName())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("Api MovieFlix")
                .sign(algorithm);
    }
    public Optional<JWTuserDate> validade(String token) {
       try {
           Algorithm algorithm = Algorithm.HMAC256(codigo);
           DecodedJWT verify = JWT.require(algorithm)
                   .build()
                   .verify(token);


           return Optional.of(JWTuserDate.builder()
                   .id(verify.getClaim("userId").asLong())
                   .name(verify.getClaim("name").asString())
                   .email(verify.getSubject())
                   .build()
           );
       }catch (JWTVerificationException ex) {
           return Optional.empty();
       }
    }




}
