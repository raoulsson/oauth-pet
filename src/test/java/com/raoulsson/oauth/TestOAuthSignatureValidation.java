package com.raoulsson.oauth;

import junit.framework.TestCase;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * User: raoulsson
 * Date: 2013-08-09
 */
public class TestOAuthSignatureValidation extends TestCase {

    private OAuthSignatureValidation oAuthSignatureValidation = null;

    public void setUp() {
        this.oAuthSignatureValidation = new OAuthSignatureValidation();
        this.oAuthSignatureValidation.setConsumerSecret(TestDataProvider.CONSUMERSECRET);
        this.oAuthSignatureValidation.setAccessSecret(TestDataProvider.ACCESSSECRET);
    }

    public void tearDown() {
        this.oAuthSignatureValidation = null;
    }

    public void testValidation() throws GeneralSecurityException, UnsupportedEncodingException {
        oAuthSignatureValidation.validate(TestDataProvider.TIMESTAMP,
                TestDataProvider.NONCE,
                TestDataProvider.ACCESSTOKEN,
                TestDataProvider.CONSUMERKEY,
                TestDataProvider.EXPECTEDSIGNATURESTRING,
                TestDataProvider.HOST,
                TestDataProvider.METHOD,
                TestDataProvider.URI);

    }

    public void testUrlDecode() throws UnsupportedEncodingException {
        assertEquals("tnnArxj06cWHq44gCs1OSKk/jLY=", oAuthSignatureValidation.decodeUrl("tnnArxj06cWHq44gCs1OSKk%2FjLY%3D"));
    }
}
