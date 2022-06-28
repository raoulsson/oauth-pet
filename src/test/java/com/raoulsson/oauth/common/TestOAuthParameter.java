package com.raoulsson.oauth.common;

import junit.framework.TestCase;

import java.util.List;

/**
 * User: raoulsson
 * Date: 2013-11-26
 */
public class TestOAuthParameter extends TestCase {

    private final OAuthSignatureBuilder oAuthSignatureBuilder = new OAuthSignatureBuilder();

    public void testToString() {
        List<OAuthParameter> params = oAuthSignatureBuilder.getSortedOAuthParameters(TestDataProvider.CONSUMERKEY, TestDataProvider.ACCESSTOKEN);
        oAuthSignatureBuilder.addUrlParameters("http://127.0.0.1:9000/api?email_address=raoul.schmidiger@gmail.com&password=gogogo", params);

        String encodedEmailValue = null;
        for (OAuthParameter p : params) {
            if (p.getKey().equals("email_address")) {
                assertEquals("email_address=raoul.schmidiger@gmail.com", p.toString());
            }
        }
    }

}
