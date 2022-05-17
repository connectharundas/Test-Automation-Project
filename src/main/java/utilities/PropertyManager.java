package utilities;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author Harundas
 */

public class PropertyManager {
    /**
     * config.property reader
     */
    static Properties property;
    static
    {
        property=new Properties();
        try {
            FileReader reader=new FileReader(System.getProperty("user.dir")+"/config.properties");
            property.load(reader);
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String propertyKey) {
        return property.getProperty(propertyKey);
    }
}
