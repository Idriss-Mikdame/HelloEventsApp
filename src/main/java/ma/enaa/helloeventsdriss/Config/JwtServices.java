package ma.enaa.helloeventsdriss.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServices {
        private static final String SECRET_KEY = "6YdrRMxphlfIFVFtY8hPBKcBhplZ+V+RHlZQ0rQfsyg=";


    public String extractUsername(String Token) {
        return extractClaim(Token, Claims::getSubject);
    }

    public <T> T extractClaim(String Token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(Token);

        return claimsResolver.apply(claims);
    }
    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails,new HashMap<>());
    }

    public String generateToken(UserDetails userDetails, Map<String, Object> extractClaims) {

    return Jwts.builder()
            .setClaims(extractClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .signWith(getSignInKey(),SignatureAlgorithm.HS256)
            .compact();

    }
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = this.extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);  
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
            return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String Token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJwt(Token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[]  keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
