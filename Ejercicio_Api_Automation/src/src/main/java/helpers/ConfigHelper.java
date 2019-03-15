package helpers;

public class ConfigHelper
{
        public static String getUserURL() {
            return System.getProperty("baseApiURL") + System.getProperty("endpointEnding_GetUserURL");
        }

        public static String getPostURL() {
        return System.getProperty("baseApiURL") + System.getProperty("endpointEnding_GetPostURL");
        }

        public static String getTimeout() {
        return System.getProperty("timeout");
    }
}
