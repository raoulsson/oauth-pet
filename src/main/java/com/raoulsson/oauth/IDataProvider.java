package com.raoulsson.oauth;

/**
 * User: raoulsson
 * Date: 2013-09-08
 */
public interface IDataProvider {

    public long getTimestamp();
    public String getNonce();

}
