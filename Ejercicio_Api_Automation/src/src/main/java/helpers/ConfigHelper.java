package helpers;

public class ConfigHelper {
    public static String getUserURL() {
        return System.getProperty("baseApiURL") + System.getProperty("endpointEnding_GetUserURL");
    }

    public static String getTimeout() {
        return System.getProperty("timeout");
    }
}
