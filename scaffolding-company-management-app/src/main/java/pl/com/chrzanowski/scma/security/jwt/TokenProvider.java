//package pl.com.chrzanowski.scma.security.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Date;
//import java.util.stream.Collectors;
//
//@Component
//public class TokenProvider {
//    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);
//
//    private static final String AUTHORITIES_KEY = "auth";
//
//    private Key key;
//
//    @Value("${scaffolding-app.security.authentication.jwt.secret}")
//    private String secret;
//    @Value("${scaffolding-app.security.authentication.jwt.base64-secret}")
//    private String base64Secret;
//
//    private long tokenValidityInMillis = 1800L;
//    private long tokenValidityInMillisForRememberMe = 2592000L;
//
//    private long tokenValidityInSeconds = 1800L;
//    private long tokenValidityInSecondsForRememberMe =2592000L;
//
//
//
//    public TokenProvider() {
//
//    }
//
//    @PostConstruct
//    public void init() {
//        byte[] keyBytes;
//        if (secret != null && !secret.isEmpty()) {
//            log.warn("Warning: Not using a Base64-encoded JWT secret key.");
//            keyBytes = secret.getBytes(StandardCharsets.UTF_8);
//        } else {
//            log.debug("Using a Base64-encoded JWT secret key");
//            keyBytes = Decoders.BASE64.decode(base64Secret);
//        }
//        this.key = Keys.hmacShaKeyFor(keyBytes);
//        this.tokenValidityInMillis =
//                1000 * tokenValidityInSeconds;
//        this.tokenValidityInMillisForRememberMe =
//                1000 * tokenValidityInSecondsForRememberMe;
//    }
//
//    public String createToken(Authentication authentication, boolean rememberMe) {
//        String authorities = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
//
//        long now = (new Date()).getTime();
//        Date validity;
//        if (rememberMe) {
//            validity = new Date(now + this.tokenValidityInMillisForRememberMe);
//        } else {
//            validity = new Date(now + this.tokenValidityInMillis);
//        }
//
//        return Jwts.builder()
//                .setSubject(authentication.getName())
//                .claim(AUTHORITIES_KEY, authorities)
//                .signWith(key, SignatureAlgorithm.HS512)
//                .setExpiration(validity)
//                .compact();
//    }
//
//    public Authentication getAuthentication(String token) {
//        Claims claims = Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//
//        Collection<? extends GrantedAuthority> authorities =
//                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//        User principal = new User(claims.getSubject(), "", authorities);
//
//        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
//    }
//
//    public boolean validateToken(String authToken) {
//        try {
//            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            log.info("Invalid JWT token.");
//            log.trace("Invalid JWT token trace.", e);
//        }
//        return false;
//    }
//}
