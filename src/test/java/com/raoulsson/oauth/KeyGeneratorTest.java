package com.raoulsson.oauth;

import junit.framework.TestCase;

/**
 * User: raoulsson
 * Date: 2013-08-12
 */
public class KeyGeneratorTest extends TestCase {

    public void testCreateKey() {
        KeyGenerator keyGenerator = new KeyGenerator(30);
        String key = keyGenerator.createKey();
        key = keyGenerator.createKey();
        System.out.println("oauth token: " + key);
        System.out.println("oauth secret: " + key);
        keyGenerator = new KeyGenerator(50);
        keyGenerator = new KeyGenerator(21);
        key = keyGenerator.createKey();
        System.out.println("consumer token: " + key);
        keyGenerator = new KeyGenerator(41);
        key = keyGenerator.createKey();
        System.out.println("consumer key: " + key);
    }
}
