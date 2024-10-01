package com.example.backendusersapp.auth;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class TokenJwtConfig {
    //  public final static String SECRET_KEY = "algun_token_con_palabra_secreta";
//    public final static Key SECRET_KEY = Jwts.build();;
//    public final static String PREFIX_TOKEN = "Bearer ";
//    public final static String HEADER_AUTHORIZATION = "Authorization";
//    SecretKey key = Jwts.build();

    public final static Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public final static String PREFIX_TOKEN = "Bearer ";
    public final static String HEADER_AUTHORIZATION = "Authorization";
}
