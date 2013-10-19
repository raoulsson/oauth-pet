package com.raoulsson.oauth.server;

/**
 * User: raoulsson
 * Date: 2013-10-19
 */
public class OAuthPetServerExampleUsage {

    /**
     * Based on the consumerToken and accessToken sent by the request you got to retrieve the secrets from somewhere.
     * (Not actually working, see other use cases for that.
     */
    public void demoServerUsage() {
        final String consumerSecret = "consumerSecret";
        final String accessSecret = "accessSecret";

        OAuthPetServer server = new OAuthPetServer(consumerSecret, accessSecret);

        OAuthRequestParameters params = new OAuthRequestParameters();

        // These come with the request oauth header
        params.setTimestamp("1382194819555");
        params.setNonce("mmgnlvle7j3qdsmgpj4e1vr3m2");
        params.setConsumerToken("consumerToken");
        params.setAccessToken("setAccessToken");
        params.setSignature("hkQ3VNuuhsiYOPoTCu%2FJWH4UZWk%3D");
        params.setUrl("http://www.somehost.com/api");
        params.setUrlParams("method=listProducts&orderBy=ID&email=bob%40somehost.com");

        boolean b = server.validateSignature(params);
    }

}
