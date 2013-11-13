package com.raoulsson.oauth;

import com.raoulsson.oauth.client.OAuthPetClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: raoulsson
 * Date: 2013-11-13
 */
public class TwitterDemo {

    private String oauthAccessToken = "oauthAccessToken";
    private String oauthAccessTokenSecret = "oauthAccessTokenSecret";
    private String consumerKey = "consumerKey";
    private String consumerSecret = "consumerSecret";

    private String url = "https://api.twitter.com/1.1/statuses/user_timeline.json?count=1";

    public static void main(String[] args) throws IOException {
        TwitterDemo twitterDemo = new TwitterDemo();
        twitterDemo.fetchTweets();
    }

    private void fetchTweets() throws IOException {
        OAuthPetClient oAuthPetClient = new OAuthPetClient();
        String authHeader = oAuthPetClient.computeOAuthHeader(url, consumerKey, consumerSecret, oauthAccessToken, oauthAccessTokenSecret);

        System.out.println(authHeader);

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        request.addHeader("Authorization", authHeader);

        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader
                (new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }
}
