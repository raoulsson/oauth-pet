package com.raoulsson.oauth.common;

import junit.framework.TestCase;

import java.util.List;

/**
 * User: raoulsson
 * Date: 2013-08-13
 */
public class TestOAuthHeaderBuilder extends TestCase {

    private OAuthSignatureBuilder oAuthSignatureBuilder;
    private OAuthHeaderBuilder oAuthHeaderBuilder;
    private IDataProvider testDataProvider = new TestDataProvider();

    public void setUp() {
        this.oAuthHeaderBuilder = new OAuthHeaderBuilder();
        this.oAuthSignatureBuilder = new OAuthSignatureBuilder();
        this.oAuthSignatureBuilder.setDataProvider(testDataProvider);
        this.oAuthHeaderBuilder.setOAuthSignatureBuilder(oAuthSignatureBuilder);
    }

    public void tearDown() {
        this.oAuthSignatureBuilder = null;
    }

    public void testComputeAuthorizationHeader() {
        List<OAuthParameter> params = oAuthSignatureBuilder.getSortedOAuthParameters(TestDataProvider.CONSUMERKEY, TestDataProvider.ACCESSTOKEN);
        oAuthSignatureBuilder.addUrlParameters("http://127.0.0.1:9000/api?name=john&age=26&gender=male", params);
        String actualAuthorizationHeader = oAuthHeaderBuilder.computeAuthorizationHeader(params, TestDataProvider.EXPECTEDHMACSHA1);
        assertEquals(TestDataProvider.EXPECTEDAUTHORIZATIONHEADER, actualAuthorizationHeader);
    }

    public void testEscaping() {
        assertEquals("http://127.0.0.1:9000/api?city=Z%C3%BCrich&street=Hohlstr.%2030", oAuthHeaderBuilder.escapeUrlParamsUTF8("http://127.0.0.1:9000/api?city=Zürich&street=Hohlstr. 30"));
    }
}
