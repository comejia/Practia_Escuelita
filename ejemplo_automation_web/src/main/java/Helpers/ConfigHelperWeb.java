package Helpers;

import java.io.File;

public class ConfigHelperWeb {

    public static String getBrowserName() {
        return System.getProperty("browserName");
    }

    public static int getAppDefaultWait() {
        return Integer.parseInt(System.getProperty("appDefaultWait"));
    }

    /**
     * Get driver path
     * @param browserName browser name to use
     * @return String driver absolute path
     */
    public static String getDriverPath(String browserName) {

        String driverName = System.getProperty(browserName + "DriverName");
        String osName = (System.getProperty("os.name").toUpperCase().contains("LINUX")) ? "linux" : "windows";
        String arch = System.getProperty("os.arch");
        return getProjectPath() + File.separator + System.getProperty("driverFolderBase") + File.separator
                + osName + File.separator +  arch + File.separator + driverName;
    }

    public static String getTestFilesPath() {
        return  getProjectPath() + System.getProperty("testFilesPath");
    }

    /**
     * Get Project folder path
     * @return String path
     */
    private static String getProjectFolderPath() {
        return System.getProperty("user.dir");
    }

    /**
     * Get Project path
     * @return String project path
     */
    private static String getProjectPath() {
        return System.getProperty("user.dir").replaceAll(
                File.separator + System.getProperty("rootProject.name"), "");
    }

}
