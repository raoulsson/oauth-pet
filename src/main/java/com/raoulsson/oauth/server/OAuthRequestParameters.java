package com.raoulsson.oauth.server;

/**
 * User: raoulsson
 * Date: 2013-10-19
 */
public class OAuthRequestParameters {

    private String timestamp;
    private String nonce;
    private String consumerToken;
    private String accessToken;
    private String signature;
    private String url;
    private String urlParams;
    private String method = "GET";

    public OAuthRequestParameters() {

    }

    public OAuthRequestParameters(String timestamp,
                                  String nonce,
                                  String consumerToken,
                                  String accessToken,
                                  String signature,
                                  String url,
                                  String urlParams) {
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.consumerToken = consumerToken;
        this.accessToken = accessToken;
        this.signature = signature;
        this.url = url;
        this.urlParams = urlParams;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getConsumerToken() {
        return consumerToken;
    }

    public void setConsumerToken(String consumerToken) {
        this.consumerToken = consumerToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlParams() {
        return urlParams;
    }

    public void setUrlParams(String urlParams) {
        this.urlParams = urlParams;
    }

    public String getMethod() {
        return method;
    }

}
