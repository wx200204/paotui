package com.example.newsb.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenUtils {

    private static long expire=604800;
    //token过期时间单位是秒
    private  static  String   secret="adegfcbadoimj";
    public static String getSecret(){
        return secret;
    }
    //token密钥

    //生成token
    public static  String generateToken(String userid){
        Date now= new Date() ;
        Date expiration =new Date(now.getTime()+1000*expire);
        System.out.println(expiration);
        //一秒等于1000毫秒
        return JWT.create().withAudience(userid)
                .withExpiresAt(expiration)
                .sign(Algorithm.HMAC256(secret));



    }


}