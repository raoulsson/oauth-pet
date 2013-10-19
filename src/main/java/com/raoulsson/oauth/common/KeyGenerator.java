package com.raoulsson.oauth.common;

import java.security.SecureRandom;
import java.util.Random;

/**
 * User: raoulsson
 * Date: 2013-08-13
 */
public class KeyGenerator {

    private static final String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789-_";
    private final Random secureRandomProvider = new SecureRandom();
    private final char[] buffer;

    public KeyGenerator(int length) {
        buffer = new char[length];
    }

    public String createKey() {
        for (int idx = 0; idx < buffer.length; ++idx) {
            buffer[idx] = symbols.charAt(secureRandomProvider.nextInt(symbols.length()));
        }
        return new String(buffer);
    }
}
