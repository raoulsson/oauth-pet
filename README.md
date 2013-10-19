oauth-pet
=========

Java library for OAuth1.0a. Can be used for Client and Server, 2-legged or 3-legged. GET only so far. Use OAuthPetClient and OAuthPetServer facades or use the code directly. Example usage documented through the unit tests but also a bit more  clearly in OAuthPetClientExampleUsage and OAuthPetServerExampleUsage.

Note that the server part does not yet evaluate the NONCE and TIMESTAMP so Retry-Attacks are possible. Plan is to implement this by end of October 2013.

I use this lib as there is a bug in the Playframework (https://github.com/playframework/playframework/issues/1159). I have not yet used it against twitter and co, just my own client and server. So if there is a bug that makes it incompatible with the spec, I am sorry. Will test that in a little while.

If you are looking for a build, look here: http://www.raoulsson.com/oauth-pet

In the Scala / Playframework context, use it like this (Client side):

    val oAuthPetClient = new OAuthPetClient()
    val authHeaderValue = oAuthPetClient.computeOAuthHeader(....)  
    val authHeader = ("Authorization" -> authHeaderValue)
    val responsePromise = WS.url(url).withHeaders(authHeader).get 


