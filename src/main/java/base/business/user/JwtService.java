/*package base.business;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class JwtService {
    private static final String SECRET_KEY = "ZBouMCyRekuPPsAHAPDLAgS58c9niLTC";
    public String generateToken (String username){
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.ES256,SECRET_KEY)
                .compact();
    }
    public String getUsernameToken (String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJwt(token).getBody();
        return claims.getSubject();
    }

}*/
