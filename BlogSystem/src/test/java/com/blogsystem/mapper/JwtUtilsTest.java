package com.blogsystem.mapper;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtilsTest {
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidGVzdCIsImlkIjoxLCJleHAiOjE3Mzk4NzU5MDB9.2wZjlBMu_h5F7Jv0iimfm5lZ3YeOehpmUYIw0HLWEGQ";
    Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf"));

    @Test
    public void getToken() {


        Map<String, Object> claim = new HashMap<>();
        claim.put("id", 1);
        claim.put("name", "test");

        String token = Jwts.builder().setClaims(claim)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(key)
                .compact();

        System.out.println(token);

    }
    @Test
    public void getKey() {
        // 随机生成一个key
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String key = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(key);
    }

    @Test
    public void parsedToken() {
        int a = 10;
        int b = a;
        b = 30;
        System.out.println(a);
    }
}
