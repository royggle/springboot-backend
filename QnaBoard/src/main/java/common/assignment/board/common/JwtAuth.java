package common.assignment.board.common;


import java.time.Duration;
import java.util.Date;
import java.util.Map;

import com.assignment.board.models.Member;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtAuth {
	private static String privateKey = "privateKey";

    public static String tokenCreate(Map<String, Object> member) {
        Date now = new Date();
        return Jwts.builder()
            .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
            .setExpiration(new Date(now.getTime() + Duration.ofMinutes(60 * 24).toMillis()))
            .setSubject("login")
            .setClaims(member)
            .signWith(SignatureAlgorithm.HS256, privateKey)
            .compact();
    }

    public static Member tokenCheck(String token) {
    	Map<String, Object> map = Jwts.parser().setSigningKey(privateKey).parseClaimsJws(token).getBody();
    	Member member = new Member((Integer) map.get("member_idx"), (String) map.get("id"));
        return member;
    }
}
