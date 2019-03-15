package Helpers;

import org.junit.Assert;

import java.io.IOException;
import java.util.Properties;


/**
 * Read language property
 */
public class ReadProperty {

    /**
     * Template of the general property file path
     */
    private static final String GENERAL_PROPERTIES_FILE_PATH = "/info.properties";
        /**
     * Property object
     */
    private static Properties generalProp = null;

    /**
     * Initialize method
     */
    private static void initilize() {

        if (generalProp == null) {
            generalProp = new Properties();
            try {
                generalProp.load(ReadProperty.class.getClass()
                    .getResourceAsStream(GENERAL_PROPERTIES_FILE_PATH));
            } catch (IOException e) {}
        }
    }

    /**
     * Get property value
     *
     * @param key to find
     * @return String key value
     * @throws Exception
     */
    public static String getProperty(String key) throws Exception {

        String value = findProperty(key);

        if (value == null) {
            throw new Exception("The key " + key + " not exist.");
        }

        return value;

    }

    /**
     * Get property by template
     *
     * @param templateKey key tamplate
     * @param key to find
     * @param defaultKey default key
     * @return String key value
     * @throws Exception
     */
    public static String getTemplateProperty(String templateKey, String key, String defaultKey) {

        String value = findProperty(String.format(templateKey, key));
        if (value == null) {
            value = findProperty(String.format(templateKey, defaultKey));
        }
        Assert.assertNotNull("No existe la propiedad '" + String.format(templateKey, defaultKey) + "'", value);
        return value;
    }

    /**
     * Find key in properties
     *
     * @param key key name
     * @return String name of property file
     */
    private static String findProperty(String key)  {
        initilize();
        if(System.getProperty(key) != null) {
            return System.getProperty(key);
        }

        return (generalProp.containsKey(key)) ? generalProp.getProperty(key) : null;
    }

    /**
     * Check if exist key
     *
     * @param key to find
     * @return <true> the key exist
     */
    public static boolean isPropertyExist(String key)  throws Exception {

        return findProperty(key) != null;
    }

    /**
     * Get int value from property file
     *
     * @param key to find
     * @return int value
     */
    public static int getPropertyInt(String key) throws Exception {
        int value = 0;
        try {
            value = Integer.valueOf(getProperty(key)).intValue();
        } catch (NumberFormatException e) {
            throw new Exception("The key '" + key
                    + "' is not a int value. The actual value is '" + getProperty(key) + "'.");
        }
        return value;
    }

}
