package com.njcebbank.merchants.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author：不许人间见白头 Time：2020/12/8 9:15
 * JWTtoken验证生成 和解析工具类
 */
public class JWTUtil {
    //设置token过期时间-15分钟
    private static final long EXPIRE_TIME = 30 * 60 * 1000;
    //设置token私钥
    private static final String SECRET_KEY = "njcebbanktysh2020";

    /*
     * 生成签名
     */
    public static String sign(String username, String password) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("pwd", password)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检验token是否正确
     * @param **token**
     * @return
     */
    public static boolean verify(String token,String username,String password){
        try {
            Algorithm algorithm = Algorithm.HMAC256(password+SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username",username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    /**
     * 从token中获取username信息,无需解密
     * @param **token**
     * @return
     */
    public static String getUserName(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            if(System.currentTimeMillis()-jwt.getExpiresAt().getTime()>0){
                return null;
            }
            String loginName = jwt.getClaim("username").asString();
            return loginName;
        } catch (JWTDecodeException e){
            e.printStackTrace();
            return null;
        }
    }
}
