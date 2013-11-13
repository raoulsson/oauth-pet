package com.raoulsson.oauth.common;

/**
 * User: raoulsson
 * Date: 2013-08-09
 */
public class TestDataProvider implements IDataProvider {

    public final static String METHOD = "GET";
    public final static String HOST = "http://127.0.0.1:9000/api";
    public final static String URI = "";
    public final static String CONSUMERKEY = "ckaWMsS9xUygosxYpI";
    public final static String CONSUMERSECRET = "csTSvnIKIsG1OvEWRU";
    public final static String ACCESSTOKEN = "atnWaWMsS9xUy&gosxYpI";
    public final static String ACCESSSECRET = "as7KfFO%oN0xBSWf";

    public final static String EXPECTEDPARAMETERSTRING = "age=26&gender=male&name=john&oauth_consumer_key=ckaWMsS9xUygosxYpI&oauth_nonce=bg57u3ppe1mu485f6nphu0sbu3&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1376061713059&oauth_token=atnWaWMsS9xUy%26gosxYpI&oauth_version=1.0";
    public final static String PARAMETERSTRING = EXPECTEDPARAMETERSTRING;
    public final static String EXPECTEDSIGNATURESTRING = "GET&http%3A%2F%2F127.0.0.1%3A9000%2Fapi&age%3D26%26gender%3Dmale%26name%3Djohn%26oauth_consumer_key%3DckaWMsS9xUygosxYpI%26oauth_nonce%3Dbg57u3ppe1mu485f6nphu0sbu3%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D1376061713059%26oauth_token%3DatnWaWMsS9xUy%2526gosxYpI%26oauth_version%3D1.0";
    public final static String SIGNATUREBASESTRING = EXPECTEDSIGNATURESTRING;
    public final static String EXPECTEDHMACSHA1 = "lx81O8+RgLaNN97m1GhNe/N/xWc=";

    public final static String EXPECTEDAUTHORIZATIONHEADER = "OAuth oauth_consumer_key=\"ckaWMsS9xUygosxYpI\", oauth_nonce=\"bg57u3ppe1mu485f6nphu0sbu3\", oauth_signature_method=\"HMAC-SHA1\", oauth_timestamp=\"1376061713059\", oauth_token=\"atnWaWMsS9xUy%26gosxYpI\", oauth_version=\"1.0\", oauth_signature=\"lx81O8%2BRgLaNN97m1GhNe%2FN%2FxWc%3D\"";

    public final static String TIMESTAMP = "1376061713";
    public final static String NONCE = "bg57u3ppe1mu485f6nphu0sbu3";
    public final static String URL_PARAMS = "/?name=john&age=26&gender=male";

    @Override
    public long getTimestamp() {
        return 1376061713059L;
    }

    @Override
    public String getNonce() {
        return "bg57u3ppe1mu485f6nphu0sbu3";
    }

}
