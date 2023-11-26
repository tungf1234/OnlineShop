package Util;

/**
 * This class contains constants related to Google OAuth2 authentication.
 * It provides values for Google client ID, client secret, redirect URI,
 * token retrieval link, user information retrieval link, and grant type.
 *
 * @author User
 */
public class Constants {
    /**
     * Google Client ID for OAuth2 authentication.
     */
    public static String GOOGLE_CLIENT_ID = "780232171487-l3i8u7rg7s73qp009p3t775n065ghvp9.apps.googleusercontent.com";

    /**
     * Google Client Secret for OAuth2 authentication.
     */
    public static String GOOGLE_CLIENT_SECRET = "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";

    /**
     * Google OAuth2 Redirect URI.
     */
    public static String GOOGLE_REDIRECT_URI = "http://localhost:9999/laptop_online_shop/loginemail";

    /**
     * Google token retrieval link for exchanging the authorization code for an access token.
     */
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";

    /**
     * Google user information retrieval link for obtaining user information using the access token.
     */
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

    /**
     * Google OAuth2 grant type used for authorization code exchange.
     */
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
