package com.us.wapp.util;

/**
 * Constant Field Which is  used in application for Configuration.
 * @author UmaShankar
 * @since 14-Feb-2019
 *
 */
public class AppConstant {
	public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 172_800_000; // 2 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
