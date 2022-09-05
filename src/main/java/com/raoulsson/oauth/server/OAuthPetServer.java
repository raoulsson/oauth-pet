package com.raoulsson.oauth.server;

import com.raoulsson.oauth.common.OAuthSignatureValidation;

/**
 * Facade to demonstrate the use on the server side (or to use directly).
 *
 * User: raoulsson
 * Date: 2013-10-19
 */
public class OAuthPetServer {

    private String method = "GET";

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
        try {
            validator.setConsumerSecret(consumerSecret);
            validator.setAccessSecret(accessSecret);
            return validator.validate(requestTimestamp, requestNonce, requestAccessToken, requestConsumerToken, requestSignature, requestUrl, method, requestUrlParams);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateSignature(String requestTimestamp,
                                     String requestNonce,
                                     String requestAccessToken,
                                     String requestConsumerToken,
                                     String requestSignature,
                                     String requestUrl,
                                     String requestUrlParams) {
        return validateSignature(this.consumerSecret,
                this.accessSecret,
                requestTimestamp,
                requestNonce,
                requestAccessToken,
                requestConsumerToken,
                requestSignature,
                requestUrl,
                requestUrlParams);
    }

    public boolean validateSignature(OAuthRequestParameters p) {
        return validateSignature(this.consumerSecret, this.accessSecret, p);
    }

    public boolean validateSignature(String consumerSecret, String accessSecret, OAuthRequestParameters p) {
        try {
            return validateSignature(
                    consumerSecret,
                    accessSecret,
                    p.getTimestamp(),
                    p.getNonce(),
                    p.getAccessToken(),
                    p.getConsumerToken(),
                    p.getSignature(),
                    p.getUrl(),
                    p.getUrlParams());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }
}
