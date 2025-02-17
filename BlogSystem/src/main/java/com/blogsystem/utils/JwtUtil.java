package com.blogsystem.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;
import java.util.Map;
@Slf4j
public class JwtUtil {
    private static final long expiration = 1000 * 60 * 60 * 24 * 24;
    private static final String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidGVzdCIsImlkIjoxLCJleHAiOjE3Mzk4NzU5MDB9.2wZjlBMu_h5F7Jv0iimfm5lZ3YeOehpmUYIw0HLWEGQ";
    private static final Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("qwertfhbdrstuwrqqweasdqweasdqwewdfawetqasdfasdf"));
    public static String getToken(Map<String, Object> claim) {
        String token = Jwts.builder()
                .setClaims(claim) // 设置载荷
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // 设置过期时间
                .signWith(key) // 设置签名
                .compact(); // 生成token
        return token;
    }
    public static Claims parseJWT(String token) {
        if (token == null) {
            return null;
        }
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        Claims claims = null;
        try {
            claims = build.parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            log.error("解析token失败");
        }
        return claims;
    }
}
