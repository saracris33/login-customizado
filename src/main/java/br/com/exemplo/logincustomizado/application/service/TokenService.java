package br.com.exemplo.logincustomizado.application.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

/*
 * CLASSE UTILIZADA PARA CRIAR O TOKEN JWT 
 */
@AllArgsConstructor
@Service
public class TokenService {
	
	private final JwtEncoder encoder;



    /*
     * OS TOKENS SAO GERADOS TODA VEZ QUE EXECUTA ESSE METODO
     */
    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        Set<String> authorities = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toSet());
        
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer(authentication.getName())
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("roles", authorities)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
