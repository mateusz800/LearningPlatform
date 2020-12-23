package com.example.configuration.security;

public class JWTSecurityConfiguration {
    public static final long EXPIRATION_INTERVAL = 10 * 60 * 1000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";
    public static final String TOKEN_NAME = "jwt";
    public final static String AUTH_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMng33fVqt+1vUCurYOmBbAXdBRlc9PZ3bxICEqG02T" +
            "/Y5NO/0XWldMj363q9ocE24Ik1SVDnzn6I5RnCvUqW7ECAwEAAQ=="; // TODO: dynamically change it after some period of time
}
