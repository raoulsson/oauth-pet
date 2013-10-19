package com.raoulsson.oauth.server;

import com.raoulsson.oauth.common.OAuthSignatureValidation;

/**
 * Facade to demonstrate the use on the server side (or to use directly).
 *
 * User: raoulsson
 * Date: 2013-10-19
 */
public class OAuthPetServer {

    private final OAuthSignatureValidation validator = new OAuthSignatureValidation();

    private String consumerSecret;
    private String accessSecret;

    public OAuthPetServer() {

    }

    public OAuthPetServer(String consumerSecret, String accessSecret) {
        this.consumerSecret = consumerSecret;
        this.accessSecret = accessSecret;
    }

    public boolean validateSignature(String consumerSecret,
                                     String accessSecret,
                                     String requestTimestamp,
                                     String requestNonce,
                                     String requestAccessToken,
                                     String requestConsumerToken,
                                     String requestSignature,
                                     String requestUrl,
                                     String requestUrlParams) {
        OAuthRequestParameters oAuthRequestParameters = new OAuthRequestParameters(requestTimestamp,
                requestNonce,
                requestAccessToken,
                requestConsumerToken,
                requestSignature,
                requestUrl,
                requestUrlParams);
        return validateSignature(consumerSecret, accessSecret, oAuthRequestParameters);
    }

    public boolean validateSignature(String requestTimestamp,
                                     String requestNonce,
                                     String requestAccessToken,
                                     String requestConsumerToken,
                                     String requestSignature,
                                     String requestUrl,
                                     String requestUrlParams) {
        OAuthRequestParameters oAuthRequestParameters = new OAuthRequestParameters(requestTimestamp,
                requestNonce,
                requestAccessToken,
                requestConsumerToken,
                requestSignature,
                requestUrl,
                requestUrlParams);
        return validateSignature(this.consumerSecret, this.accessSecret, oAuthRequestParameters);
    }

    public boolean validateSignature(OAuthRequestParameters p) {
        return validateSignature(this.consumerSecret, this.accessSecret, p);
    }

    public boolean validateSignature(String consumerSecret, String accessSecret, OAuthRequestParameters p) {
        validator.setConsumerSecret(consumerSecret);
        validator.setAccessSecret(accessSecret);
        try {
            return validator.validate(p.getTimestamp(),
                    p.getNonce(),
                    p.getAccessToken(),
                    p.getConsumerToken(),
                    p.getSignature(),
                    p.getUrl(),
                    p.getMethod(),
                    p.getUrlParams());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
