package com.raoulsson.oauth.common;

import junit.framework.TestCase;

import java.security.GeneralSecurityException;
import java.util.List;

/**
 * User: raoulsson
 * Date: 2013-08-09
 */
public class TestOAuthSignatureBuilder extends TestCase {

    private OAuthSignatureBuilder oAuthSignatureBuilder;
    private final IDataProvider testDataProvider = new TestDataProvider();

    public void setUp() {
        this.oAuthSignatureBuilder = new OAuthSignatureBuilder();
        this.oAuthSignatureBuilder.setDataProvider(testDataProvider);
    }

    public void tearDown() {
        this.oAuthSignatureBuilder = null;
    }

    public void testAddUrlParameters() {
        List<OAuthParameter> params = oAuthSignatureBuilder.getSortedOAuthParameters(TestDataProvider.CONSUMERKEY, TestDataProvider.ACCESSTOKEN);
        oAuthSignatureBuilder.addUrlParameters("http://127.0.0.1:9000/api?name=john&age=26&gender=male", params);
        assertTrue(params.contains(new OAuthParameter("name", "john")));
        assertTrue(params.contains(new OAuthParameter("age", "26")));
        assertTrue(params.contains(new OAuthParameter("gender", "male")));
    }

    public void testAddUrlParametersUnbalanced() {
        List<OAuthParameter> params = oAuthSignatureBuilder.getSortedOAuthParameters(TestDataProvider.CONSUMERKEY, TestDataProvider.ACCESSTOKEN);
        oAuthSignatureBuilder.addUrlParameters("http://127.0.0.1:9000/api?name=&age=26&gender=male", params);
        assertTrue(params.contains(new OAuthParameter("name", "")));
        assertTrue(params.contains(new OAuthParameter("age", "26")));
        assertTrue(params.contains(new OAuthParameter("gender", "male")));
    }

    public void testUrlParametersGetPercentEscaped() {
        List<OAuthParameter> params = oAuthSignatureBuilder.getSortedOAuthParameters(TestDataProvider.CONSUMERKEY, TestDataProvider.ACCESSTOKEN);
        oAuthSignatureBuilder.addUrlParameters("http://127.0.0.1:9000/api?street=Hegibachstrasse 34", params);
        assertTrue(params.contains(new OAuthParameter("street", "Hegibachstrasse 34")));
    }

    public void testComputeParameterString() {
        List<OAuthParameter> params = oAuthSignatureBuilder.getSortedOAuthParameters(TestDataProvider.CONSUMERKEY, TestDataProvider.ACCESSTOKEN);
        oAuthSignatureBuilder.addUrlParameters("http://127.0.0.1:9000/api?name=john&age=26&gender=male", params);
        String actualParameterString = oAuthSignatureBuilder.computeParameterString(params);
        System.out.println("actualParameterString = " + actualParameterString);
        assertEquals("age=26&gender=male&name=john&oauth_consumer_key=ckaWMsS9xUygosxYpI&oauth_nonce=bg57u3ppe1mu485f6nphu0sbu3&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1376061713059&oauth_token=atnWaWMsS9xUy&gosxYpI&oauth_version=1.0", actualParameterString);
    }

//    public void testComputeSignatureBaseString() {
//        String actualSignatureBaseString = oAuthSignatureBuilder.computeSignatureBaseString(TestDataProvider.METHOD, TestDataProvider.HOST, TestDataProvider.PARAMETERSTRING);
//        System.out.println("actualSignatureBaseString = " + actualSignatureBaseString);
//        assertEquals("GET&http://127.0.0.1:9000/api&age=26&gender=male&name=john&oauth_consumer_key=ckaWMsS9xUygosxYpI&oauth_nonce=bg57u3ppe1mu485f6nphu0sbu3&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1376061713059&oauth_token=atnWaWMsS9xUy%26gosxYpI&oauth_version=1.0", actualSignatureBaseString);
//    }

    public void testCalculateHmacSha1() throws GeneralSecurityException {
        String actualHmacSha1 = oAuthSignatureBuilder.calculateHmacSha1(TestDataProvider.CONSUMERSECRET, TestDataProvider.ACCESSSECRET, TestDataProvider.SIGNATUREBASESTRING);
        assertEquals(TestDataProvider.EXPECTEDHMACSHA1, actualHmacSha1);
    }

//    public void testSign() throws GeneralSecurityException {
//        List<OAuthParameter> params = oAuthSignatureBuilder.getSortedOAuthParameters(TestDataProvider.CONSUMERKEY, TestDataProvider.ACCESSTOKEN);
//        oAuthSignatureBuilder.addUrlParameters("http://127.0.0.1:9000/api?name=john&age=26&gender=male", params);
//        String signature = oAuthSignatureBuilder.sign(TestDataProvider.METHOD, "http://127.0.0.1:9000/api?name=john&age=26&gender=male", TestDataProvider.CONSUMERSECRET, TestDataProvider.ACCESSSECRET, params);
//        assertEquals("hsdArFs/Dw5X5saeumKrg0zhDRk=", signature);
//    }

    public void testSign2() throws GeneralSecurityException {
        List<OAuthParameter> params = oAuthSignatureBuilder.getSortedOAuthParameters(TestDataProvider.CONSUMERKEY, TestDataProvider.ACCESSTOKEN);
        oAuthSignatureBuilder.addUrlParameters("http://127.0.0.1:9000/api?email_address=raoul.schmidiger@gmail.com&password=gogogo", params);

        String encodedEmailValue = null;
        for (OAuthParameter p : params) {
            if (p.getKey().equals("email_address")) {
                encodedEmailValue = p.getValue();
            }
        }
        assertNotNull(encodedEmailValue);
        assertEquals("raoul.schmidiger@gmail.com", encodedEmailValue);

        oAuthSignatureBuilder.sign(TestDataProvider.METHOD, "http://127.0.0.1:9000/api?name=john&age=26&gender=male", TestDataProvider.CONSUMERSECRET, TestDataProvider.ACCESSSECRET, params);

    }

    public void testUrlParamStripOff() {
        assertEquals("http://127.0.0.1:9000/api", oAuthSignatureBuilder.stripOffUrlParams("http://127.0.0.1:9000/api?name=john&age=26&gender=male"));
    }

}
