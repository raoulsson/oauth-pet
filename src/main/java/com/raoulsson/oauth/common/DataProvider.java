package com.raoulsson.oauth.common;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

/**
 * User: raoulsson
 * Date: 2013-08-09
 */
public class DataProvider implements IDataProvider {

    private Random random = new Random();

    @Override
    public long getTimestamp() {
        return new Date().getTime();
    }

    @Override
    public String getNonce() {
        return new BigInteger(130, random).toString(32);
    }
}
