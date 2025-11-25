
package com.example.travelbackend.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;

@Component
public class JwtUtil {

    @Value("${app.jwt.secret}")
    private String SECRET;

    @Value("${app.jwt.expiration-ms}")
    private Long EXP_MS;

    public String generateToken(String username, String role){
        return Jwts.builder().setSubject(username).claim("role", role)
                .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+EXP_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    public boolean validateToken(String token, String username){
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        try{
            Date exp = extractClaim(token, Claims::getExpiration);
            return exp.before(new Date());
        }catch(Exception e){ return true; }
    }
}
