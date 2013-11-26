package com.raoulsson.oauth.server;

import junit.framework.TestCase;

import java.util.Objects;

/**
 * User: raoulsson
 * Date: 2013-11-14
 */
public class TestTMeier extends TestCase {

    class Meier {
        int i = 200;
        String s = "hello world";

        public void doStuff() {
            // nothing hree.
        }

        @Override
        public String toString() {
            return "Meier{" +
                    "i=" + i +
                    ", s='" + s + '\'' +
                    '}';
        }
    }

    public void testTM() {
        Object o = new Object();
        System.out.println("o = " + o);

        Meier o2 = new Meier();
        System.out.println("o2 = " + o2);
    }
}
