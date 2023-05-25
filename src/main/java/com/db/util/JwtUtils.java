package com.db.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.db.entity.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-03 17:29
 */
public class JwtUtils {
    private static long expire = 604800;

    // 32为密钥
    private static String secret = "248abd887c7e40ce84b25ef253e6ff8d";

    private static Map<String, User> tokenMap = new HashMap<>();
    public static String generateToken(User user){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 30); //默认七天过去
        String token = JWT.create()
                .withClaim("telephone", user.getTelephone())
                .withClaim("username", user.getUsername())
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    public static DecodedJWT getClaimsByToken(String token){
        // 创建验证对象
        JWTVerifier build = JWT.require(Algorithm.HMAC256(secret)).build();
        try{
            DecodedJWT verify = build.verify(token);
            //System.out.println(verify.getClaim("telephone").asString());
            return verify;
        }catch (Exception e){
            return null;
        }


    }
}
