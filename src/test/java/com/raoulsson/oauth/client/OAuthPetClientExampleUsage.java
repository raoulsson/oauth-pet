package com.raoulsson.oauth.client;

import junit.framework.TestCase;

/**
 * User: raoulsson
 * Date: 2013-10-19
 */
public class OAuthPetClientExampleUsage extends TestCase{

    /**
     * After the owner of the data of the data we want to access has authorized us against the provider, the provider
     * will give us our consumer token/secret as well as the one of the owner, the access token/secret (unique for us
     * to do stuff on behalf of "him".
     */
    public void testDemoClientUsage() {
        // Load these from somewhere. They will not change in the usual workflow.
        final String consumerToken = "consumerToken";
        final String consumerSecret = "consumerSecret";
        final String accessToken = "accessToken";
        final String accessSecret = "accessSecret";

        OAuthPetClient client = new OAuthPetClient(consumerToken, consumerSecret, accessToken, accessSecret);

        // Now create the GET url with parameters URL encoded
        String url = "http://www.somehost.com/api?method=listProducts&orderBy=ID&email=" + client.escape("bob@somehost.com");

        String oauthHeader = client.computeOAuthHeader(url);
        System.out.println(oauthHeader);
    }
}
