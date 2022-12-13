package org.example.util;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Classname JwtHelper
 * @Date 2022/12/12 16:08
 * @Author 花非
 * @Version 1.0
 * @Description
 */
public class JwtHelper {
    private static long tokenExpiration = 24*60*60*1000;//令牌过期时间
    private static String tokenSignKey = "123456";//盐

    //创建用户id和用户名称，创建jwt令牌
    public static String createToken(Long userId, String userName) {
        String token = Jwts.builder()
                .setSubject("bzhl-user")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId", userId)
                .claim("userName", userName)
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }


    //从jwt令牌中解析出用户id，用户名称
    public static Long getUserId(String token) {
        if(StringUtils.isEmpty(token)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer)claims.get("userId");
        return userId.longValue();
    }
    public static String getUserName(String token) {
        if(StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws
                = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("userName");
    }
}
